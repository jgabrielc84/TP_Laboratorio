package edu.utn.dao;

import java.sql.*;
import java.util.*;

import edu.utn.entity.DBConnection;

public class DataAccess {

    protected List<Map<String, Object>> read(String sql, Map<Integer, Object> parameters) {

        List<Map<String, Object>> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metadata = null;
        
        try {
            connection = DBConnection.getDBConnection();
            preparedStatement = getStatement(sql, parameters, connection);
            resultSet = preparedStatement.executeQuery();
            metadata = resultSet.getMetaData();

            // Mediante los metadatos, es posible obtener el nombre de la columna y el valor; si consideramos un
            // registro como un conjunto de columnas con sus valores, es posible modelarlo con un map.
            // Adicionalmente, como la consulta puede devolver varios registros, se emplea una lista para guardarlos,
            // ya que mantiene el orden y es fácil de recorrer.
            while(resultSet.next()) {
                HashMap<String, Object> columns = new HashMap<>();

                for (int i = 1; i <= metadata.getColumnCount(); ++i) {
                    columns.put(metadata.getColumnName(i), resultSet.getObject(i));
                }
                results.add(columns);
            }

        } catch (SQLException exception) {
            // TODO: excepcion :D!
            System.out.println(exception.getMessage());
        }  catch (Exception exception) {
            // TODO: excepcion :D!
            System.out.println(exception.getMessage());
        } finally {
            // se cierra la conexion
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }

        return results;     //no le gusta el return dentro del Finaly
    }

    protected int write(String sql, Map<Integer, Object> parameters) {
        int returnedValue = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //ResultSet generatedKeys = null;

        try {
            connection = DBConnection.getDBConnection();
            preparedStatement = getStatement(sql, parameters, connection);

            returnedValue = preparedStatement.executeUpdate();

            // En el caso de un UPDATE o DELETE, se devuelve la cantidad de registros afectados.
            // En el caso de un INSERT, se devuelve el id generado
            if (returnedValue > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    // TODO: es posible cambiar esta estructura por una expresión ternaria
                    if (generatedKeys.next()) {
                        returnedValue = generatedKeys.getInt(1);
                    }
                } catch (Exception exception) {
                    // TODO: analizar qué ocurre si se loguea por la salida standard
                    System.out.println("No keys to be retrieved");
                }
            }

        } catch (SQLException exception) {
            // TODO: analizar qué ocurre si se loguea por la salida standard
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            // TODO: excepcion :D!
        } finally {
            // se cierra la conexion
            try {
                //generatedKeys.close(); // Revisar porque no deja cerrar el Resulset desde acá(ver arriba Resulset comentado)
                //preparedStatement.close();
                connection.close();
            } catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }

        return returnedValue;
    }

    private PreparedStatement getStatement(String sql, Map<Integer, Object> parameters, Connection connection) throws SQLException {
        // TODO: no todos los drivers manejan la misma configuración para larecuperación de los ids
        //String generatedColumns[] = { "ID" };
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // Al usar prepared statement se garantiza seguridad contra sql injection, pero es necesario
        // implementar una estrategia para el reemplazo de los "wildcards" por los valores deseados
        if (parameters != null) {
            Set<Integer> keys = parameters.keySet();
            for (Integer key : keys) {
                Object value = parameters.get(key);
                preparedStatement.setObject(key, value);
            }
        }

        return preparedStatement;
    }
    
}
