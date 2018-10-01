package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
}