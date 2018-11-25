package ru.innopolis.stc12.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.spring.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.getStudentsList());
        return "listOfStudents";
    }

    @RequestMapping(value = "/addStudentUrl", method = RequestMethod.POST)
    public String addStudent(
            @RequestParam(value = "studentName", required = true) String studentName,
            @RequestParam(value = "studentFamilyName", required = true) String studentFamilyName,
            @RequestParam(value = "studentAge", required = true) String studentAge,
            @RequestParam(value = "studentGroup", required = true) String studentGroup,
            Model model) {
        studentService.addStudent(studentName, studentFamilyName, studentAge, studentGroup);
        return "addStudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String showAddStudent(Model model) {
        return "addStudent";
    }
}
