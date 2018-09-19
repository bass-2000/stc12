package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addStudent(Student student) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT  into students values(default , ?, ?, ?, ?,?)");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getFamily_name());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getContact());
            preparedStatement.setInt(5, student.getCity());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudentById(int id) {
        return false;
    }
}
