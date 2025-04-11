package ir.maktabsharif127.jdbc;

import ir.maktabsharif127.jdbc.config.ApplicationContext;
import ir.maktabsharif127.jdbc.domains.Province;
import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.ProvinceRepository;
import ir.maktabsharif127.jdbc.repository.UserRepository;

import java.sql.SQLException;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        UserRepository userRepository = applicationContext.getUserRepository();
        Optional<User> optionalUser = userRepository.findById(1001);
        optionalUser.ifPresent(System.out::println);

        ProvinceRepository provinceRepository = applicationContext.getProvinceRepository();
        Optional<Province> provinceOptional = provinceRepository.findById(3);
        provinceOptional.ifPresent(System.out::println);

        applicationContext.getConnection().close();
    }

}
