package ir.maktabsharif127.jdbc;

import ir.maktabsharif127.jdbc.config.ApplicationContext;
import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.UserRepository;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        UserRepository userRepository = applicationContext.getUserRepository();

        User user = new User();
        user.setUsername("tom");
        user.setFirstName("tommi");
        user.setLastName("tommi");
        user.setAge(25);
        System.out.println("before insert: " + user);
        userRepository.create(user);
        System.out.println("after insert: " + user);

    }

}
