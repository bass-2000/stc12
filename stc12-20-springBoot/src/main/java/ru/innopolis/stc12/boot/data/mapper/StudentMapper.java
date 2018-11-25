package ru.innopolis.stc12.boot.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.boot.data.pojo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setName(rs.getString("name"));
        student.setFamilyName(rs.getString("family_name"));
        student.setAge(rs.getInt("age"));
        student.setGroup(rs.getString("contact"));
        return student;
    }
}
