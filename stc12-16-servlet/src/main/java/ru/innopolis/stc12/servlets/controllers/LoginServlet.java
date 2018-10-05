package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.repository.dao.UserDaoImpl;
import ru.innopolis.stc12.servlets.service.UserService;
import ru.innopolis.stc12.servlets.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "login";
    private static Logger logger = Logger.getLogger(LoginServlet.class);
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }
        try {
            if (req.getSession().getAttribute(LOGIN) != null) {
                resp.sendRedirect("/inner/dashboard");
            } else
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter("password");
        try {
            if (userService.checkAuth(login, password)) {
                int role = userService.getRole(login);
                req.getSession().setAttribute(LOGIN, login);
                req.getSession().setAttribute("role", role);
                resp.sendRedirect("/inner/dashboard");
            } else {
                resp.sendRedirect("/login?action=wrongUser");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
