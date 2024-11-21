package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Courses {

    @NotEmpty(message = "Error: id is empty!")
    @Size(min=4, message = "Error:Must id length is more then 4")
    private String id;
    @NotEmpty(message = "Error:name is empty")
    @Size(min=2, message = "Error:Must name length is more then 4")
    private String name;
    @NotNull(message = "Error:hours is null")
    @Positive(message = "Error:hours only allowed is positive number")
    private int hours;
    @JsonIgnore
    private ArrayList<Grades> grades = new ArrayList<>();;
}
