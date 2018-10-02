package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    boolean addCity(City city);
}
