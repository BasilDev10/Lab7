package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.GradeScore;
import com.example.lab7.Model.Grades;
import com.example.lab7.Service.GradeScoreService;
import com.example.lab7.Service.GradesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grade-score")
@RequiredArgsConstructor
public class GradeScoreController {

    private final GradeScoreService gradeScoreService;


    @GetMapping("/get")
    public ResponseEntity getGradesScore(){
        return ResponseEntity.ok(gradeScoreService.getGradesScore());
    }
    // @PostMapping("/add/{studentId}/{coureseId}")
    //@PathVariable String studentId , @PathVariable String coureseId,
    @PostMapping("/add")
    public ResponseEntity addGradesScore(@RequestBody @Valid GradeScore gradeScore , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));


        gradeScoreService.addGradesScore(gradeScore);
        return ResponseEntity.status(201).body(new ApiResponse("Grade score is added"));
//        if(gradesService.addGradesScore(studentId , coureseId, grade) != null)return ResponseEntity.status(201).body(new ApiResponse("Grades Score is added"));
//        else return ResponseEntity.status(400).body(new ApiResponse("studentId or coureseId is not found"));

    }

    @PutMapping("/update/{gradeScoreId}/{typeGrade}")
    public ResponseEntity updateGradeScore(@PathVariable String gradeScoreId  ,@RequestBody @Valid GradeScore gradeScore , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        if(gradeScoreService.updateGradeScore(gradeScoreId ,gradeScore))return ResponseEntity.ok(new ApiResponse("grade score is updated"));
        else return ResponseEntity.status(400).body(new ApiResponse("Grade is not found"));
    }
    @DeleteMapping("/delete/{studentId}/{coureseId}")
    public ResponseEntity deleteGradeScore(@PathVariable String gradeScoreId ){

        if(gradeScoreService.deleteGradeScore(gradeScoreId))return ResponseEntity.ok(new ApiResponse("grade score is deleted"));
        else return ResponseEntity.status(400).body(new ApiResponse("Grade core is not found"));
    }
}
