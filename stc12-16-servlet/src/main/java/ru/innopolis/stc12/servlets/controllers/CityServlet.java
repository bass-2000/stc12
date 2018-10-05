package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.pojo.City;
import ru.innopolis.stc12.servlets.service.CityService;
import ru.innopolis.stc12.servlets.service.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
    private CityService cityService;
    private static Logger logger = Logger.getLogger(CityServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        cityService = new CityServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<City> list = cityService.getAllCities();
        req.setAttribute("list", list);
        try {
            req.getRequestDispatcher("/cities.jsp").forward(req, resp);
        } catch (ServletException | IOException se) {
            logger.error(se.getMessage());
        }
    }

    //TBD
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            City city = new City(0, req.getParameter("CityName"), Integer.parseInt(req.getParameter("Population")));
            cityService.addCity(city);
        } catch (NumberFormatException e) {
            logger.error(e.getMessage());
        }
    }
}
