package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.pojo.Student;
import ru.innopolis.stc12.servlets.service.StudentService;
import ru.innopolis.stc12.servlets.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    private static Logger logger = Logger.getLogger(StudentServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentService.getAllStudents();
        req.setAttribute("list", list);
        try {
            req.getRequestDispatcher("/students.jsp").forward(req, resp);
        } catch (ServletException | IOException se) {
            logger.error(se.getMessage());
        }
    }
}