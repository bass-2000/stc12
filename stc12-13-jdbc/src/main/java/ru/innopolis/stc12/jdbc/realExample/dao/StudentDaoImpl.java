package ru.innopolis.stc12.jdbc.realExample.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.dao.mappers.StudentMapper;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    private static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    @Override
    public boolean addStudent(Student student) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            CityDaoImpl cityDao = new CityDaoImpl();
            if (cityDao.getCityById(student.getCity().getId()) == null) cityDao.addCity(student.getCity());
            preparedStatement = connection.prepareStatement(SQLqueries.INSERT_INTO_STUDENTS_VALUES);
            preparedStatement = StudentMapper.getPreparedStatementFromStudent(preparedStatement, student);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        Connection connection = connectionManager.getConnection();
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLqueries.SELECT_STUDENT_BY_ID);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                student = StudentMapper.getStudentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return student;
    }

    public List<Student> getStudentsByCity(int cityId) {
        Connection connection = connectionManager.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQLqueries.SELECT_STUDENTS_BY_CITY);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, cityId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(StudentMapper.getStudentFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return students;
    }

    @Override
    public boolean updateStudent(Student student) {
        CityDaoImpl cityDao = new CityDaoImpl();
        if (cityDao.getCityById(student.getCity().getId()) == null) cityDao.addCity(student.getCity());
        if (student.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        SQLqueries.UPDATE_STUDENTS_BY_ID);
                preparedStatement = StudentMapper.getPreparedStatementFromStudent(preparedStatement, student);
                preparedStatement.setInt(6, student.getId());
                preparedStatement.execute();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(int id) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLqueries.DELETE_FROM_STUDENTS_BY_ID);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

}