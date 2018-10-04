package ru.innopolis.stc12.servlets.repository.dao.mappers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.pojo.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentMapper {
    private static Logger logger = Logger.getLogger(StudentMapper.class);
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
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }


}
