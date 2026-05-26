package com.ca.courseapp.service;

import com.ca.courseapp.dto.StudentsDto;
import com.ca.courseapp.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);
    List<StudentsDto> getAllStudents();
    Optional<Student> getStudent(Long id);
    Optional<Student> updateStudent(Long id,Student student);
    Optional<Student> deleteStudent(Long id);
}
