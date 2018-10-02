package ru.innopolis.stc12.servlets.controllers;

import ru.innopolis.stc12.servlets.pojo.City;
import ru.innopolis.stc12.servlets.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
    private CityService cityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> list = cityService.getAllCities();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/cities.jsp").forward(req, resp);
    }

    //TBD
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        City city = new City(0, req.getParameter("CityName"), Integer.parseInt(req.getParameter("Population")));
        cityService.addCity(city);
//        super.doPost(req, resp);
    }
}
