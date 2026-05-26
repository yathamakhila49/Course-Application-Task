package com.ca.courseapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_phno")
    private String studentPhno;

    @Column(name = "student_age")
    private Integer age;

    @Column(name = "student_gender")
    private String gender;


    @Column(name = "student_address")
    private String address;

    @Column(name = "student_dob")
    private LocalDate studentDob;


    @ManyToMany
    @JoinTable(name="student_courses",joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name="course_id"))
   private List<Course> courses;

}
