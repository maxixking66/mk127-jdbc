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
                        "select id, first_name, last_name, age from users where first_name like '%m%' order by id limit 10"
                )
                ) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        int age = resultSet.getInt("Age");

                        System.out.println(id + " " + firstName + " " + lastName + " " + age);

                    }
                }
            }
        }

    }

}