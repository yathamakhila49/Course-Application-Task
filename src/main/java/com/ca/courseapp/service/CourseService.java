package com.ca.courseapp.service;

import com.ca.courseapp.entities.Course;

import java.util.List;

public interface CourseService {
  Course addCourse(Course course);
  List<Course> getAllCourses();

}
