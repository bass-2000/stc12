package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private static String testString = "";
    private static Logger logger = Logger.getLogger(HelloServlet.class);

    public static String getTestString() {
        return testString;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().println("testString = " + testString);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            testString = req.getParameter("testText");
            req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        } catch (ServletException | IOException se) {
            logger.error(se.getMessage());
        }
    }
}