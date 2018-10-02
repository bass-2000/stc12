package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.City;
import ru.innopolis.stc12.servlets.repository.dao.CityDao;
import ru.innopolis.stc12.servlets.repository.dao.CityDaoImpl;

import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDao cityDao;

    public CityServiceImpl() {
        cityDao = new CityDaoImpl();
    }

    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.getAllCities();
    }

    @Override
    public boolean addCity(City city) {
        return cityDao.addCity(city);
    }
}
