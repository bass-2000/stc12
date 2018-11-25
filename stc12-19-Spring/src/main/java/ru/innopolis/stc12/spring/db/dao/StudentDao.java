package ru.innopolis.stc12.spring.db.dao;

import ru.innopolis.stc12.spring.db.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentsList();

    void addStudent(Student student);
}
