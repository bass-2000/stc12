package ru.innopolis.stc12.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc12.boot.service.StudentService;

@Controller
public class WelcomeController {
    StudentService studentService;
    @Value("${myProperties.message:test}")
    private String message;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", this.message);
        model.addAttribute("student", studentService.getStudentById(2));
        return "welcome";
    }
}
