package ru.innopolis.stc12.servlets.repository.dao.mappers;

import ru.innopolis.stc12.servlets.pojo.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentMapper {
    private StudentMapper() {
    }


    public static PreparedStatement getPreparedStatementFromStudent(PreparedStatement preparedStatement, Student student) {
        try {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getFamilyName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getContact());
            preparedStatement.setInt(5, student.getCity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }


}
