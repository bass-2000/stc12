package ru.innopolis.stc12.jdbc.realExample;

import ru.innopolis.stc12.jdbc.realExample.dao.StudentDaoImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

public class Main {

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student = new Student(0, "Alexander", "Pushkin", 26, "jgdgjs", 4);
        studentDao.addStudent(student);
    }
}
