package ru.innopolis.stc12.spring.db.dao;

import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.spring.db.pojo.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    private List<Student> students = new ArrayList();

    public StudentDaoImpl() {
        students.add(new Student(1, "Mikhail", "Ivanov", 21, "STC-13"));
        students.add(new Student(2, "Ivan", "Petrov", 22, "STC-13"));
        students.add(new Student(3, "Vladimir", "Aleksandrov", 18, "STC-13"));
        students.add(new Student(4, "Andrey", "Zaripov", 19, "STC-13"));
    }

    @Override
    public List<Student> getStudentsList() {

        return students;
    }

    @Override
    public void addStudent(Student student) {
        //TODO: добавить работу с БД
        students.add(student);
    }
}
