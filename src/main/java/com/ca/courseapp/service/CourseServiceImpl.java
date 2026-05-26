package com.ca.courseapp.service;


import com.ca.courseapp.dto.CoursesDto;
import com.ca.courseapp.entities.Course;
import com.ca.courseapp.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }
    @Override
   public Course addCourse(Course course){
        return courseRepository.save(course);
    }
    @Override
    public Page<CoursesDto> getAllCourses(int page,int size){
       Pageable pageable = PageRequest.of(page,size);
       Page <Course> coursePage=courseRepository.findAll(pageable);
        return coursePage.map(course -> new CoursesDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getDescription(),
                course.getPrice(),
                course.getLevel(),
                course.getInstructorName(),
                course.getDuration(),
                course.getRating()
        ));
    }
    @Override
    public Optional<Course> getCourse(Long id){
        return courseRepository.findById(id);
    }
    @Override
    public Course updateCourse(Long id,Course course){
        Course existingCourse=courseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("course not found"));
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setPrice(course.getPrice());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setInstructorName(course.getInstructorName());
        existingCourse.setDuration(course.getDuration());
        existingCourse.setRating(course.getRating());
        return courseRepository.save(existingCourse);

    }
    @Override
    public void deleteCourse(Long id){
        Course existingCourse=courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course not found"));
        courseRepository.delete(existingCourse);

    }

}
