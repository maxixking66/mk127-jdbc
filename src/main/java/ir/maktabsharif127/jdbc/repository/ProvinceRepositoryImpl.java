package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.Province;
import ir.maktabsharif127.jdbc.repository.base.CrudRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceRepositoryImpl extends CrudRepositoryImpl<Province, Integer>
        implements ProvinceRepository {

    public ProvinceRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, Province entity) {
        try {
            entity.setId(
                    resultSet.getInt(1)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void fillInsertValues(PreparedStatement statement, Province province) {
        try {
            statement.setString(1, province.getName());
            statement.setString(2, province.getPreCode());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                Province.NAME_COLUMN,
                Province.PRE_CODE_COLUMN
        };
    }

    @Override
    protected String getTableName() {
        return Province.TABLE_NAME;
    }

    @Override
    protected Province mapResultSetToEntity(ResultSet resultSet) {
        Province entity = new Province();
        try {
            entity.setId(resultSet.getInt(Province.ID_COLUMN));
            entity.setName(resultSet.getString(Province.NAME_COLUMN));
            entity.setPreCode(resultSet.getString(Province.PRE_CODE_COLUMN));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }
}
