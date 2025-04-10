package ir.maktabsharif127.jdbc;

import java.sql.*;
import java.util.Properties;

public class Application {

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "123456789");

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        properties
                )
        ) {

            System.out.println("connection is open");

            String findByIdQuery = "select * from users where last_name = ? or first_name = ?";
//            String findByIdQuery = "select * from users where id = 188888 or 1 = 1";

            try (PreparedStatement statement = connection.prepareStatement(findByIdQuery)) {
                statement.setString(1, "asgari");
                statement.setString(2, "ali");
                try (ResultSet resultSet = statement.executeQuery()) {
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