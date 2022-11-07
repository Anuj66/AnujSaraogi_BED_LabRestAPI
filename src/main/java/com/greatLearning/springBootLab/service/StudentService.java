package com.greatLearning.springBootLab.service;

import com.greatLearning.springBootLab.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    Student updateStudent(Student student);
}
