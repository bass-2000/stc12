package ru.innopolis.stc12.jdbc.realExample.dao.mappers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.jdbc.realExample.pojo.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper {
    private static Logger logger = Logger.getLogger(CityMapper.class);
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
            logger.error(e.getMessage());
        }
        return city;
    }

    public static PreparedStatement getPreparedStatementFromCity(PreparedStatement preparedStatement, City city) {
        try {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromCityId(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }
}

