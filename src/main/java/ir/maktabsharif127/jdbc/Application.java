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
                try (ResultSet resultSet = statement.executeQuery(
                        "select * from users where id = 1001"
                )
                ) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        int age = resultSet.getInt("Age");
                        String username = resultSet.getString("username");

                        System.out.println(id + " " + firstName + " " + lastName + " " + age + " " + username);

                    }
                }

                System.out.println(
                        "result of executeUpdate is " + statement.executeUpdate("update users set username = 'mat' where id in (1001, 1003)")
                );

                try (ResultSet resultSet = statement.executeQuery(
                        "select * from users where id = 1001"
                )
                ) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        int age = resultSet.getInt("Age");
                        String username = resultSet.getString("username");

                        System.out.println(id + " " + firstName + " " + lastName + " " + age + " " + username);

                    }
                }

            }
        }

    }

}