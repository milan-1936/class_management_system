package com.example.studentdashboard.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getDBConnect(){
        String databaseName = "dev_scl_test2";
        String databaseUser = "root";
        String databasePassword = "password123";
        String url = "jdbc:mysql://localhost/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);


        }catch(Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
