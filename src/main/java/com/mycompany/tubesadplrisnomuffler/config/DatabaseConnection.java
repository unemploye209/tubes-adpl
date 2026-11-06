package com.mycompany.tubesadplrisnomuffler.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/risno_muffler";

    private static final String USER = "root";

    private static final String PASSWORD = "ISI_PASSWORD_MYSQL_LU";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

            System.out.println("Database berhasil terhubung!");

            return connection;

        } catch (SQLException e) {
            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());

            return null;
        }
    }
}
