package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Grades {
    @NotEmpty(message = "Error : id not empty")
    @Size(min = 4, message = "Error: id length is more then 4")
    private String id;
    @Positive(message = "Error:final Grade only allowed is positive number")
    @Max(value = 100,message ="Error: the max of total grade is 100")
    private double finalGrade;
    @Positive(message = "Error:course point only allowed is positive number")
    @Max(value = 5,message ="Error: the max of coursePoint is 5")
    private double coursePoint;
    @Pattern(regexp = "Passed|NotPassed|NotFinished" , message = "Error: Pass Course only allowed enter Passed|NotPassed|NotFinished")
    private String passCourse;
    private Courses courses;
    private Student student;
    @JsonIgnore
    private ArrayList<GradeScore> gradeScores = new ArrayList<>();

    public Grades(){

    }

    public Grades(String id ,double finalGrade,double coursePoint, String passCourse , Courses courses , Student student ,ArrayList<GradeScore> gradeScores ){

        this.id = id;
        calculateFinalGrade();
        calculateCoursePoint();
        this.passCourse = passCourse;
        this.courses = courses;
        this.student =student;
        this.gradeScores = gradeScores;
    }

    public void calculateFinalGrade(){
        double finalGrade = 0;
        for (GradeScore gradeScore : this.gradeScores){
            finalGrade += gradeScore.getStudentGrade();
        }
        this.finalGrade = finalGrade;
    }

    public void calculateCoursePoint(){
        if(this.finalGrade >= 95){
            this.coursePoint = 5;
        }else if(this.finalGrade >=90){
            this.coursePoint = 4.75;
        }else if(this.finalGrade >= 85){
            this.coursePoint = 4.5;
        }else if(this.finalGrade >= 80){
            this.coursePoint = 4;
        }else if(this.finalGrade >= 75){
            this.coursePoint = 3.5;
        }else if(this.finalGrade >= 70){
            this.coursePoint = 3;
        }else if(this.finalGrade >= 65){
            this.coursePoint = 2.5;
        }else if(this.finalGrade >= 60){
            this.coursePoint = 2;
        }else if(this.finalGrade >=55){
            this.coursePoint = 1.5;
        }else if(this.finalGrade >= 50){
            this.coursePoint = 1;
        }else {
            this.coursePoint = 0;
        }

    }
}
