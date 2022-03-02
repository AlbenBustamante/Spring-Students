package com.alnicode.students.service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Student save(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return this.studentRepo.findById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        return this.getStudentById(studentId).map(student -> {
            this.studentRepo.deleteById(studentId);
            return true;
        }).orElse(false);
    }
    
}
