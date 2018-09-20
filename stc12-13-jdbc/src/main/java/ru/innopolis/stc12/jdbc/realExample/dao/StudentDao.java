package ru.innopolis.stc12.jdbc.realExample.dao;

import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

public interface StudentDao {
    boolean addStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean deleteStudentById(int id);
}
