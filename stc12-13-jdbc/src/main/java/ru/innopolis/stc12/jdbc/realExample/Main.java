package ru.innopolis.stc12.jdbc.realExample;

import ru.innopolis.stc12.jdbc.realExample.dao.StudentDaoImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.City;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

public class Main {

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        City city = new City(0, "Kazan", 75000);
        Student student = new Student(0, "Alexander", "Pushkin", 26, "jgdgjs", city);
        studentDao.addStudent(student);
    }
}
