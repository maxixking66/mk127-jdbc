package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.base.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

//    List<User> findAllByFirstNameLike(String firstName);

    boolean existsByUsername(String username);
}
