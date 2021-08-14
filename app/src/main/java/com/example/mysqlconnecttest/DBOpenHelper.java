package com.example.mysqlconnecttest;

import java.sql.*;


public class DBOpenHelper {

    private static String diver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://www.amazonaws.com:3306/DatabaseName?"; //jdbc:mysql: + databaseURL + port number + databaseName
    private static String user = "admin";//Username"
    private static String password = "password";//passsword

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    /*
     * connect database
     * */
    public static Connection getConn(){
        try {
            //Class.forName(diver);
            Class.forName(diver).newInstance();
            connection = DriverManager.getConnection(url,user,password);//getConnection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeAll() throws Exception{
        if (connection != null) {
            connection.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (resultSet != null) {
            resultSet.close();
        }

    }
}
