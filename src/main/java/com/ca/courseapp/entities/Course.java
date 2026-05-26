package com.ca.courseapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_title")
    private String courseName;

    @Column(name = "course_desc")
    private String Description;

    @Column(name = "course_instructor")
    private String instructorName;

    @Column(name = "course_price")
    private Double Price;

    @Column(name = "course_category")
    private String category;

    @Column(name = "course_level")
    private String level;

    @Column(name = "course_language")
    private String language;

    @Column(name = "course_duration")
    private String duration;

    @Column(name = "course_rating")
    private Double rating;


    @Column(name = "total_students")
    private Integer totalStudents;


    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;

}
