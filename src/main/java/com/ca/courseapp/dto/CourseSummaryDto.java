package com.ca.courseapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSummaryDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String level;
    private String instructorName;
    private String duration;
    private Double rating;
}
