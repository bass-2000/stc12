package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.Student;
import ru.innopolis.stc12.servlets.repository.dao.StudentDao;
import ru.innopolis.stc12.servlets.repository.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}