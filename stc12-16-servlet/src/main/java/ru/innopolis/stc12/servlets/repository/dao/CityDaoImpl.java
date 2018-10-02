package ru.innopolis.stc12.servlets.repository.dao;


import ru.innopolis.stc12.servlets.pojo.City;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.servlets.repository.dao.mappers.CityMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<City> getAllCities() {
        List<City> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLqueries.SELECT_ALL_CITIES);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                result = CityMapper.getListOfCitiesFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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