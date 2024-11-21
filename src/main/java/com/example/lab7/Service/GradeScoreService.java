package com.example.lab7.Service;

import com.example.lab7.Model.GradeScore;
import com.example.lab7.Model.Grades;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GradeScoreService {

    ArrayList<GradeScore> gradeScores = new ArrayList<>();



    public ArrayList<GradeScore>  getGradesScore(){
        return gradeScores;
    }

    public void addGradesScore(GradeScore gradeScore){
        gradeScores.add(gradeScore);
    }

    public boolean updateGradeScore(String gradeScoreId  ,GradeScore gradeScore){

        for (int i =0 ; i < gradeScores.size();i++){
            if (gradeScores.get(i).getId().equalsIgnoreCase(gradeScoreId)){
                gradeScores.set(i,gradeScore);
                return true;
            }
        }

        return false;
    }

    public boolean deleteGradeScore(String gradeScoreId ){

        for (int i =0 ; i < gradeScores.size();i++){
            if (gradeScores.get(i).getId().equalsIgnoreCase(gradeScoreId)){
                gradeScores.remove(i);
                return true;
            }
        }

        return false;
    }
}
