package com.ca.courseapp.service;

import com.ca.courseapp.dto.StudentsDto;
import com.ca.courseapp.entities.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);
    Page<StudentsDto> getAllStudents(int page,int size);
    Optional<Student> getStudent(Long id);
    Optional<Student> updateStudent(Long id,Student student);
    Optional<Student> deleteStudent(Long id);
}
