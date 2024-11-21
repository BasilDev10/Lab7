package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "Error: id is empty!")
    @Size(min=4, message = "Error:Must id length is more then 4")
    private String id;
    @NotEmpty(message = "Error:name is empty")
    @Size(min=4, message = "Error:Must name length is more then 4")
    private String name;
    @NotEmpty(message = "Error: gender is empty!")
    @Pattern(regexp = "Male|Female" , message = "Error:gender only allowed enter Male or Female")
    private String gender;
    @NotEmpty(message = "Error: major is empty!")
    @Pattern(regexp = "Software|Business|Finance" , message = "Error: major only allowed enter Software or Business or Finance")
    private String major;
    @Positive(message = "Error:gpa only allowed is positive number")
    private double gpa;
    @PastOrPresent(message = "Error: Enter only past date or present date")
    private LocalDate startStudy;
    @JsonIgnore
    private ArrayList<Courses> courses;
}
