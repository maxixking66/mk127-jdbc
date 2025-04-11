package ir.maktabsharif127.jdbc.config;

import ir.maktabsharif127.jdbc.repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContext {

    private static ApplicationContext applicationContext;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        ApplicationProperties.JDBC_URL,
                        ApplicationProperties.JDBC_USER,
                        ApplicationProperties.JDBC_PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(getConnection());
        }
        return userRepository;
    }


    private ProvinceRepository provinceRepository;

    public ProvinceRepository getProvinceRepository() {
        if (provinceRepository == null) {
            provinceRepository = new ProvinceRepositoryImpl(getConnection());
        }
        return provinceRepository;
    }

    private CityRepository cityRepository;

    public CityRepository getCityRepository() {
        if (cityRepository == null) {
            cityRepository = new CityRepositoryImpl(getConnection());
        }
        return cityRepository;
    }
}
