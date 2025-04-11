package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.Province;
import ir.maktabsharif127.jdbc.repository.base.CrudRepositoryImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceRepositoryImpl extends CrudRepositoryImpl<Province, Integer>
        implements ProvinceRepository {

    public ProvinceRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Province.TABLE_NAME;
    }

    @Override
    protected Province mapResultSetToEntity(ResultSet resultSet) {
        Province province = new Province();
        try {
            province.setId(resultSet.getInt(Province.ID_COLUMN));
            province.setName(resultSet.getString(Province.NAME_COLUMN));
            province.setPreCode(resultSet.getString(Province.PRE_CODE_COLUMN));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return province;
    }
}
