package com.alnicode.students.service;

import java.util.List;

import com.alnicode.students.model.Student;
import com.alnicode.students.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) this.studentRepo.findAll();
    }
    
}
