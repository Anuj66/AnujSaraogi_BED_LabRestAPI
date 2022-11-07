package com.greatLearning.springBootLab.repository;

import com.greatLearning.springBootLab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
