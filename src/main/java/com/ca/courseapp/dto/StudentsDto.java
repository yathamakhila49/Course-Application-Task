package com.ca.courseapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsDto {

        private Long studentId;
        private String studentName;
        private String studentEmail;
        private LocalDate studentDob;
      private List<String> courses;

    }

