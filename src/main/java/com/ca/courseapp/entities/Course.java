package com.ca.courseapp.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_title")
    private String title;

    @Column(name = "course_desc")
    private String description;

    @Column(name = "course_instructor")
    private String instructorName;

    @Column(name = "course_price")
    private Double price;

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

}
