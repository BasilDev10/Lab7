package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Grades {
    @NotEmpty(message = "Error : id not empty")
    @Size(min = 4, message = "Error: id length is more then 4")
    private String id;
    @Positive(message = "Error:final Grade only allowed is positive number")
    @Max(value = 100,message ="Error: the max of total grade is 100")
    private double finalGrade;
    @Pattern(regexp = "Passed|NotPassed|NotFinished" , message = "Error: Pass Course only allowed enter Passed|NotPassed|NotFinished")
    private String passCourse;
    private Courses courses;
    private Student student;
    @JsonIgnore
    private ArrayList<GradeScore> gradeScores = new ArrayList<>();
}
