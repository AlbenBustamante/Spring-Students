package com.alnicode.students.service;

import com.alnicode.students.model.Student;
import java.util.List;

public interface StudentService {
    
    List<Student> getAllStudents();

    Student save(Student student);

    Student getStudentById(Long studentId);

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);
}
