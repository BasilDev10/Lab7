package com.example.lab7.Service;

import com.example.lab7.Model.GradeScore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeScoreService {

    ArrayList<GradeScore> gradeScores = new ArrayList<>();


    public ArrayList<GradeScore>  getGradesScore(){
        return gradeScores;
    }

    public void addGradesScore(GradeScore gradeScore){
        gradeScores.add(gradeScore);
    }
    
}
