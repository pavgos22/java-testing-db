package com.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {

    INSTANCE;                                                  // [1]

    private Connection conn;                                   // [2]

    DbManager() {                                              // [3]
        Properties connectionProps = new Properties();          // [4]
        connectionProps.put("user", "root");            // [5]
        connectionProps.put("password", "root");     // [6]
        try {
            conn = DriverManager.getConnection(                  // [7]
                    "jdbc:mysql://localhost:3306/my_db" +
                            "?serverTimezone=Europe/Warsaw" +
                            "&useSSL=False" +
                            "&allowPublicKeyRetrieval=true",
                    connectionProps);                                 // [11]
        } catch (SQLException e) {                              // [12]
            throw new ExceptionInInitializerError(e);            // [13]
        }                                                       // [14]
    }                                                          // [15]

    public static DbManager getInstance() {                    // [16]
        return INSTANCE;                                        // [17]
    }                                                          // [18]

    public Connection getConnection() {                        // [19]
        return conn;                                            // [20]
    }                                                          // [21]
}