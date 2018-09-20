package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.dao.mappers.CityMapper;
import ru.innopolis.stc12.jdbc.realExample.pojo.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addCity(City city) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLqueries.INSERT_INTO_CITIES_VALUES);
            preparedStatement = CityMapper.getPreparedStatementFromCity(preparedStatement, city);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public City getCityById(int id) {
        Connection connection = connectionManager.getConnection();
        City city = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLqueries.SELECT_CITY_BY_ID);
            preparedStatement = CityMapper.getPreparedStatementFromCityId(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                city = CityMapper.getCityFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public boolean updateCity(City city) {
        if (city.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        SQLqueries.UPDATE_CITIES_BY_ID);
                preparedStatement = CityMapper.getPreparedStatementFromCity(preparedStatement, city);
                preparedStatement.setInt(3, city.getId());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCityById(int id) {
        Connection connection = connectionManager.getConnection();
        City city = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLqueries.DELETE_FROM_CITIES_BY_ID);
            preparedStatement = CityMapper.getPreparedStatementFromCityId(preparedStatement, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}