package com.ca.courseapp.controller;


import com.ca.courseapp.dto.StudentsDto;
import com.ca.courseapp.entities.Student;
import com.ca.courseapp.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    StudentController( StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<StudentsDto>> getAllStudents(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5")int size){
        return ResponseEntity.ok(studentService.getAllStudents(page,size));
    }
    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudent(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
       Optional<Student> updateStudent= studentService.updateStudent(id,student);
       return updateStudent.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> deleteStudent=studentService.deleteStudent(id);
        return deleteStudent.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
