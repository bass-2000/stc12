package ru.innopolis.stc12.servlets.controllers;

import ru.innopolis.stc12.servlets.repository.dao.UserDaoImpl;
import ru.innopolis.stc12.servlets.service.UserService;
import ru.innopolis.stc12.servlets.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }

        if (req.getSession().getAttribute("login") != null) {
            resp.sendRedirect("/inner/dashboard");
        } else
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userService.checkAuth(login, password)) {
            int role = userService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            resp.sendRedirect("/inner/dashboard");
        } else {
            resp.sendRedirect("/login?action=wrongUser");
        }
    }
}
