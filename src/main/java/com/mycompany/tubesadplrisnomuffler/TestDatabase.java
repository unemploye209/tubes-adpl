package com.mycompany.tubesadplrisnomuffler;

import com.mycompany.tubesadplrisnomuffler.config.DatabaseConnection;
import java.sql.Connection;

public class TestDatabase {

    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("TEST BERHASIL!");
            
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("TEST GAGAL!");
        }
    }
}
