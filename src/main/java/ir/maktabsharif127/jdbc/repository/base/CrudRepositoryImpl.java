package ir.maktabsharif127.jdbc.repository.base;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl<T extends BaseEntity<ID>, ID> implements CrudRepository<T, ID> {

    protected final Connection connection;

    public CrudRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T create(T t) {
        String insertQuery = prepareInsertQuery();
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            fillInsertValues(statement, t);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                setIdInNewEntity(resultSet, t);
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void setIdInNewEntity(ResultSet resultSet, T entity);

    protected abstract void fillInsertValues(PreparedStatement statement, T t);

    protected String prepareInsertQuery() {
        String insertQueryTemplate = "INSERT INTO %S (%S) VALUES (%S)";
        String[] insertColumns = getInsertColumns();
        return String.format(
                insertQueryTemplate,
                getTableName(),
                String.join(
                        ", ",
                        insertColumns
                ),
                getQuestionMarksForInsert()
        );
    }

    private String getQuestionMarksForInsert() {
        String[] insertColumns = getInsertColumns();
        if (insertColumns == null || insertColumns.length == 0) {
            throw new RuntimeException("wrong implementation");
        }
        Arrays.fill(insertColumns, "?");
        return String.join(
                ",",
                insertColumns
        );
    }

    protected abstract String[] getInsertColumns();

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
