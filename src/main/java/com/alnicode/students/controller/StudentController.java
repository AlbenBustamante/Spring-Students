package com.alnicode.students.controller;

import com.alnicode.students.model.Student;
import com.alnicode.students.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showRegisterForm(Model model) {
        var student = new Student();
        model.addAttribute("student", student);
        return "register_student";
    }

    @PostMapping("/students")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long studentId, Model model) {
        model.addAttribute("studentId", this.studentService.getStudentById(studentId));
        return "update_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long studentId, @ModelAttribute("student") Student student) {
        student.setStudentId(studentId);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
