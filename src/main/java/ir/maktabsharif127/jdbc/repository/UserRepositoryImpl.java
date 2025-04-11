package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.User;
import ir.maktabsharif127.jdbc.repository.base.CrudRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl extends CrudRepositoryImpl<User, Integer>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, User entity) {
        try {
            entity.setId(
                    resultSet.getInt(1)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void fillInsertValues(PreparedStatement statement, User user) {
        try {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setInt(4, user.getAge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                User.USERNAME_COLUMN,
                User.FIRST_NAME_COLUMN,
                User.LAST_NAME_COLUMN,
                User.AGE_COLUMN,
        };
    }

    @Override
    protected String getTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) {
        User entity = new User();
        try {
            entity.setId(resultSet.getInt(User.ID_COLUMN));
            entity.setFirstName(resultSet.getString(User.FIRST_NAME_COLUMN));
            entity.setLastName(resultSet.getString(User.LAST_NAME_COLUMN));
            entity.setAge(resultSet.getInt(User.AGE_COLUMN));
            entity.setUsername(resultSet.getString(User.USERNAME_COLUMN));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }
}
