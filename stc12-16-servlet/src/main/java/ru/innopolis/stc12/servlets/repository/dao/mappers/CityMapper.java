package ru.innopolis.stc12.servlets.repository.dao.mappers;

import ru.innopolis.stc12.servlets.pojo.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {
    private CityMapper() {
    }

    public static City getCityFromResultSet(ResultSet resultSet) {
        City city = null;
        try {
            if (resultSet.next()) {
                city = new City(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    public static List<City> getListOfCitiesFromResultSet(ResultSet resultSet) {
        List<City> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                result.add(new City(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("population")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static PreparedStatement getPreparedStatementFromCity(PreparedStatement preparedStatement, City city) {
        try {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromCityId(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}

