package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeScore {
    @NotEmpty(message = "Error: id is empty")
    @Size(min = 4 ,message = "Error: id length more then 4")
    private String id;
    @NotEmpty(message = "Error: id is empty!")
    @Pattern(regexp = "FinalExam|MidExam|Quiz|Lab|Project" , message = "Error: type Grade only allowed enter FinalExam|MidExam|Quiz|Lab|Project")
    private String typeGrade;
    @Positive
    @Max(value = 100,message ="Error: the max of total grade is 100")
    private double totalGrade;
    @Positive
    @Max(value = 100,message ="Error: the max of student grade is 100")
    private double studentGrade;


}
