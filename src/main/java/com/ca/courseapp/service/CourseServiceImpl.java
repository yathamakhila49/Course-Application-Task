package com.ca.courseapp.service;


import com.ca.courseapp.entities.Course;
import com.ca.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Course> getAllCourses(){
        return courseRepository.findAll();

    }
}
