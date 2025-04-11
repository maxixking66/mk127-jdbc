package ir.maktabsharif127.jdbc.repository.base;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl<T extends BaseEntity<ID>, ID> implements CrudRepository<T, ID> {

    protected final Connection connection;

    public CrudRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        try (PreparedStatement statement = connection.prepareStatement(getFindByIdQuery())) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(
                        mapResultSetToEntity(resultSet)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    protected String getFindByIdQuery() {
        return "select * from " + getTableName() + " where id = ?";
    }

    protected abstract String getTableName();

    protected abstract T mapResultSetToEntity(ResultSet resultSet);

    @Override
    public int deleteById(ID id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public long countAll() {
        return 0;
    }

}
