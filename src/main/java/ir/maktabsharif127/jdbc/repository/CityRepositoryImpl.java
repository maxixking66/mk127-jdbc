package ir.maktabsharif127.jdbc.repository;

import ir.maktabsharif127.jdbc.domains.City;
import ir.maktabsharif127.jdbc.domains.Province;
import ir.maktabsharif127.jdbc.repository.base.CrudRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends CrudRepositoryImpl<City, Integer>
        implements CityRepository {

    public CityRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, City entity) {
        try {
            entity.setId(
                    resultSet.getInt(1)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void fillInsertValues(PreparedStatement statement, City city) {
        try {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getProvinceId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                City.NAME_COLUMN,
                City.PROVINCE_ID_COLUMN
        };
    }

    @Override
    protected String getTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected String getFindByIdQuery() {
        return "select * from " + getTableName() + " c join " + Province.TABLE_NAME + " p on c." + City.PROVINCE_ID_COLUMN
               + " = p." + Province.ID_COLUMN + " where c.id = ?";
    }

    @Override
    protected City mapResultSetToEntity(ResultSet rs) {
        City entity = new City();
        try {
            entity.setId(rs.getInt(1));
            entity.setName(rs.getString(2));
            entity.setProvinceId(rs.getInt(3));
            Province province = new Province();
            province.setId(entity.getProvinceId());
            province.setName(rs.getString(5));
            province.setPreCode(rs.getString(6));
            entity.setProvince(province);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }
}
