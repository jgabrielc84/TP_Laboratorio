package edu.utn.entity;

import java.sql.*;
//import java.util.*;

public class DBConection {

    private static Connection dbConnection;
    private static String dbHost;
    private static String dbPort;
    private static String url;
    private static String user;
    private static String password;

    private DBConection() {
    }

    public static void setDbHost() {
        //ACA SE LEE DESDE EL ARCHIVO DE CONFIGURACION
        DBConection.dbHost = "???";
    }
        
    public static String getDBHost() {
        return dbHost;
    }

    public static void setDbPort() {
        //ACA SE LEE DESDE EL ARCHIVO DE CONFIGURACION
        DBConection.dbPort = "???";
    }
        
    public static String getDbPort() {
        return dbPort;
    }

    public static void setPassword() {
        //ACA SE LEE DESDE EL ARCHIVO DE CONFIGURACION
        DBConection.password = "???";
    }
        
    public static String getPassword() {
        return password;
    }

    public static void setUser(String user) {
        //ACA SE LEE DESDE EL ARCHIVO DE CONFIGURACION
        DBConection.user = "???";
    }

    public static String getUser() {
        return user;
    }

    public static void setUrl() {
        //ACA SE LEE DESDE EL ARCHIVO DE CONFIGURACION
        DBConection.url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/"; //se puede mejorar
    }

    public static String getUrl() {
        return url;
    }

    public static Connection getDBConnection() throws SQLException {
        if(dbConnection == null){
            dbConnection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
        }

        return dbConnection;
    }
}
