package ru.innopolis.stc12.boot.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.boot.data.mapper.StudentMapper;
import ru.innopolis.stc12.boot.data.pojo.Student;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.setJdbcTemplate(jdbcTemplate);
    }

    public StudentDaoImpl() {
    }

    @Override
    public List<Student> getStudentsList() {
        String getStudentsQuery = "select * from students";
        return super.getJdbcTemplate().query(getStudentsQuery, new StudentMapper());
    }

    @Override
    public void addStudent(Student student) {
        String addStudentQuery = "insert into students (name, family_name, age, contact)" +
                " values (?,?,?,?)";
        super.getJdbcTemplate().update(addStudentQuery, student.getName(), student.getFamilyName(),
                student.getAge(), student.getGroup());
    }

    @Override
    public Student getStudent(Integer id) {
        String getStudentQuery = "select * from students where id=?";
        return super.getJdbcTemplate().queryForObject(getStudentQuery,
                new Object[]{id}, new StudentMapper());
    }

    @Override
    public void deleteStudent(Integer id) {
        String deleteStudentQuery = "delete from students where id=?";
        super.getJdbcTemplate().update(deleteStudentQuery, id);
    }

    @Override
    public void update(Integer id, Integer age, String name, String familyName) {
        String updateStudentQuery = "update students set name=?, family_name=?, age=? " +
                "where id=?";
        super.getJdbcTemplate().update(updateStudentQuery, name, familyName, age, id);
    }
}