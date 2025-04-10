package ir.maktabsharif127.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

            connection.setAutoCommit(false);

            System.out.println("connection is open");

            try (Statement statement = connection.createStatement()) {
                System.out.println("line 27) " + statement.executeUpdate("update users set username = 'mat10' where id = 1001"));
                implLoginWithException();
                System.out.println("line 29) " + statement.executeUpdate("update users set username = 'mat15' where id = 1001"));
                connection.commit();
            }

        }
    }

    private static void implLoginWithException() {
        throw new RuntimeException();
    }

}