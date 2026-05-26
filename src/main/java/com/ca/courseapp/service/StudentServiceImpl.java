package com.ca.courseapp.service;


import com.ca.courseapp.dto.StudentsDto;
import com.ca.courseapp.entities.Course;
import com.ca.courseapp.entities.Student;
import com.ca.courseapp.repository.CourseRepository;
import com.ca.courseapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    StudentServiceImpl(StudentRepository studentRepository,CourseRepository courseRepository){
        this.studentRepository=studentRepository;
        this.courseRepository=courseRepository;
    }
    @Override
    public Student addStudent(Student student){

        List<Long>courseIds=student.getCourses().stream().map(Course::getCourseId).toList();
        List<Course> courses =courseRepository.findAllById(courseIds);
        student.setCourses(courses);
        return studentRepository.save(student);

    }
    @Override
    public List<StudentsDto> getAllStudents(){
        return studentRepository.findAll().stream().map(student -> new StudentsDto(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentEmail(),
                student.getStudentDob(),
                student.getCourses()
                        .stream()
                        .map(Course::getCourseName)
                        .toList()
        )).toList();
    }
    @Override
    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> updateStudent(Long id, Student student) {
       return studentRepository.findById(id).map(existingStudent->{
           existingStudent.setStudentName(student.getStudentName());
           existingStudent.setStudentEmail(student.getStudentEmail());
           existingStudent.setStudentPhno(student.getStudentPhno());
           existingStudent.setStudentDob(student.getStudentDob());
           existingStudent.setAge(student.getAge());
           return studentRepository.save(existingStudent);
       });

    }
    @Override
    public Optional<Student > deleteStudent(Long id){
        return studentRepository.findById(id).map(student -> {studentRepository.delete(student);
           return student;
        });

    }

}
