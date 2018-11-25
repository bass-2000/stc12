package ru.innopolis.stc12.spring.service;

import ru.innopolis.stc12.spring.db.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentsList();

    void addStudent(String name, String familyName, String age, String group);
}
