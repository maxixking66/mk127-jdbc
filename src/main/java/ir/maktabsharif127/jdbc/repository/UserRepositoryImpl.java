package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.base.CrudRepositoryImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl extends CrudRepositoryImpl<User, Integer>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt(User.ID_COLUMN));
            user.setFirstName(resultSet.getString(User.FIRST_NAME_COLUMN));
            user.setLastName(resultSet.getString(User.LAST_NAME_COLUMN));
            user.setAge(resultSet.getInt(User.AGE_COLUMN));
            user.setUsername(resultSet.getString(User.USERNAME_COLUMN));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }
}
