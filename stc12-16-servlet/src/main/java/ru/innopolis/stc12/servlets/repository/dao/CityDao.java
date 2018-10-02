package ru.innopolis.stc12.servlets.repository.dao;


import ru.innopolis.stc12.servlets.pojo.City;

import java.util.List;

public interface CityDao {
    boolean addCity(City city);

    City getCityById(int id);

    List<City> getAllCities();

    boolean updateCity(City student);

    boolean deleteCityById(int id);
}
