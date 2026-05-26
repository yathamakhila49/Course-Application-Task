package com.ca.courseapp.service;

import com.ca.courseapp.dto.CoursesDto;
import com.ca.courseapp.entities.Course;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CourseService {
  Course addCourse(Course course);
  Page<CoursesDto> getAllCourses(int page,int size);
  Optional<Course> getCourse(Long id);
  Course updateCourse(Long id,Course course);
  void deleteCourse(Long id);

}
