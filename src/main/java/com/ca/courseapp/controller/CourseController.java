package com.ca.courseapp.controller;


import com.ca.courseapp.dto.CoursesDto;
import com.ca.courseapp.entities.Course;
import com.ca.courseapp.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<CoursesDto>> getAllCourses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){

        return ResponseEntity.ok(courseService.getAllCourses(page,size));
    }


    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return courseService.getCourse(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
   @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
        Course updatedCourse=courseService.updateCourse(id,course);
        return ResponseEntity.ok(updatedCourse);
   }
   @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted Successfully");
   }
}
