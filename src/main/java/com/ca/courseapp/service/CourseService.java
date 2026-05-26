package com.ca.courseapp.service;

import com.ca.courseapp.dto.GetCourseDto;
import com.ca.courseapp.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
  Course addCourse(Course course);
  List<GetCourseDto> getAllCourses();
  Optional<Course> getCourse(Long id);
  Course updateCourse(Long id,Course course);
  void deleteCourse(Long id);

}
