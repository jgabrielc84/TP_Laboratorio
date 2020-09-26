package edu.utn.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;


public class DBConnection {

    private static String FILEPATH = "E:\\Dropbox\\TECNICATURA\\4to Cuatrimestre\\LABORATORIO 4\\TP_Laboratorio\\src\\edu\\utn\\conectionConfig.txt";
    private static Connection dbConnection;
    private static String dbHost;
    private static String dbPort;
    private static String url = "";
    private static String user;
    private static String password;

    private DBConnection() {
    }

    private static void setDbHost(String dbHost) {
        DBConnection.dbHost = dbHost;
    }

    private static String getDBHost() {
        return dbHost;
    }

    private static void setDbPort(String dbPort) {
        DBConnection.dbPort = dbPort;
    }

    private static String getDbPort() {
        return dbPort;
    }

    private static void setPassword(String password) {
        DBConnection.password = password;
    }

    private static String getPassword() {
        return password;
    }

    private static void setUser(String user) {
        DBConnection.user = user;
    }

    private static String getUser() {
        return user;
    }

    private static void setUrl() {
        String constructUrl = "";
        DBConnection.url = constructUrl.concat("jdbc:postgresql://").concat(DBConnection.getDBHost()).concat(":").concat(DBConnection.getDbPort()).concat("/");         // se puede mejorar??
        // DBConnection.url.concat(DBConnection.getDBHost());                                                                                                           // como queda mejor??
        // DBConnection.url.concat(":");
        // DBConnection.url.concat(DBConnection.getDbPort());
        // DBConnection.url.concat("/");
    }

    private static String getUrl() {
        return url;
    }

    public static Connection getDBConnection() {
        try{
            if (dbConnection == null) {
                fillAttributes();
                dbConnection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        return dbConnection;
    }

    private static File openFile(){
        File file = null;
        try{
            file = new File(DBConnection.FILEPATH);
        }catch(Exception e){
            e.printStackTrace();
        }

        return file;
    }
    
    private static void closeFile(FileReader fr){
        try{                    
            if( null != fr ){   
                fr.close();     
            }                  
        }catch (Exception e){ 
            e.printStackTrace();
        }
        
    }

    private static void fillAttributes(){
        try{
            File file = openFile();
            FileReader fr = new FileReader (file);
            BufferedReader br = new BufferedReader(fr);

            setDbHost(br.readLine());
            setDbPort(br.readLine());
            setUser(br.readLine());
            setPassword(br.readLine());
            setUrl();

            closeFile(fr);
        }catch (Exception e){ 
            e.printStackTrace();
        }
    }
}
