package ru.innopolis.stc12.jdbc.realExample.dao.mappers;

import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper {
    private StudentMapper() {
    }

    public static Student getStudentFromResultSet(ResultSet resultSet) {
        Student student = null;
        try {
            if (resultSet.next()) {
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("family_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("contact"),
                        resultSet.getInt("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static PreparedStatement getPreparedStatementFromStudent(PreparedStatement preparedStatement, Student student) {
        try {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getFamily_name());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getContact());
            preparedStatement.setInt(5, student.getCity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromStudentId(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
