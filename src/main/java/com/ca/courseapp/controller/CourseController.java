package com.ca.courseapp.controller;


import com.ca.courseapp.entities.Course;
import com.ca.courseapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return  courseService.addCourse(course);
    }
    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
}
