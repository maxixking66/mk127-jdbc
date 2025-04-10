package ir.maktabsharif127.jdbc;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "123456789"
                )
        ) {

            System.out.println("connection is open");

            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("select id, first_name, last_name, age from users limit 10")) {
                    int row = 1;
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
//                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString(2);
                        String lastName = resultSet.getString(3);
                        int age = resultSet.getInt(4);

                        System.out.println(row++ + ")" + id + " " + firstName + " " + lastName + " " + age);

                    }
                }
            }
        }

    }

}