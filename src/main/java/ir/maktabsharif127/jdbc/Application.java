package ir.maktabsharif127.jdbc;

import ir.maktabsharif127.jdbc.domains.User;

import java.sql.*;
import java.util.Optional;
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


            findUserById(connection, 1001).ifPresent(user -> System.out.println(user.getUsername()));
            findUserById(connection, 100144).ifPresent(user -> System.out.println(user.getUsername()));

        }
    }

    private static Optional<User> findUserById(Connection connection, Integer id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("select * from users where id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
            }
            return Optional.ofNullable(user);
        }
    }

}