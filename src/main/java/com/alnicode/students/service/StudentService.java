package com.alnicode.students.service;

import com.alnicode.students.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Student save(Student student);

    Optional<Student> getStudentById(Long studentId);

    Student updateStudent(Student student);

    boolean deleteStudent(Long studentId);
}
