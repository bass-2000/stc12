package ru.innopolis.stc12.boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.boot.data.StudentDao;
import ru.innopolis.stc12.boot.data.pojo.Student;

@Service
public class StudentService {
    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(Integer id) {
        return studentDao.getStudent(id);
    }
}
