package com.alnicode.students.controller;

import com.alnicode.students.model.Student;
import com.alnicode.students.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/register")
    public String showForm(Model model) {
        var student = new Student();
        model.addAttribute("student", student);
        return "register_students";
    }

    @PostMapping("/students")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }
}
