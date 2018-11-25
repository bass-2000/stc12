package ru.innopolis.stc12.boot.data;

import ru.innopolis.stc12.boot.data.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentsList();

    void addStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    void update(Integer id, Integer age, String name, String familyName);

}
