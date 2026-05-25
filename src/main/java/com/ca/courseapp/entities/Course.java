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
    @Column(name = "course_price")
    private Double price;
}
