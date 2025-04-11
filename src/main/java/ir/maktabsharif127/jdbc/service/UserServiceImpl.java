package ir.maktabsharif127.jdbc.service;

import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<User, Integer, UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User create(User user) {
        validateInput(user);
        return super.create(user);
    }

    private void validateInput(User user) {
        validateUsernameForInsert(user.getUsername());
    }

    private void validateUsernameForInsert(String username) {
        if (repository.existsByUsername(username)) {
            throw new RuntimeException("duplicate username");
        }
    }
}
