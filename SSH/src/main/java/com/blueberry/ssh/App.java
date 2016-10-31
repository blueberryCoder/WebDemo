package com.blueberry.ssh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/27.
 */
public class App {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test01?useSSL=false&userUnicode=true&characterEncoding=utf8" +
                            "&serverTimezone=UTC",
                    "blueberry"
            ,"992036795");

            if(connection!=null && !connection.isClosed()){
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
