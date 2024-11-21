package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Grades;
import com.example.lab7.Service.GradesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grades")
@RequiredArgsConstructor
public class GradesController {
    private final GradesService gradesService;

    @GetMapping("/get")
    public ResponseEntity getGrades(){
        return ResponseEntity.ok(gradesService.getGrades());
    }
   // @PostMapping("/add/{studentId}/{coureseId}")
    //@PathVariable String studentId , @PathVariable String coureseId,
    @PostMapping("/add")
    public ResponseEntity addGrades( @RequestBody @Valid Grades grade , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        gradesService.addGreade(grade);
        return ResponseEntity.status(201).body(new ApiResponse("grade is added"));
//        if(gradesService.addGreade(studentId , coureseId, grade) != null)return ResponseEntity.status(201).body(new ApiResponse("grade is added"));
//        else return ResponseEntity.status(400).body(new ApiResponse("studentId or coureseId is not found"));

    }

    @PutMapping("/update/{studentId}/{coureseId}")
    public ResponseEntity updateGrade(@PathVariable String studentId , @PathVariable String coureseId ,@RequestBody @Valid Grades grade , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        if(gradesService.updateGrade(studentId,coureseId,grade))return ResponseEntity.ok(new ApiResponse("grade is updated"));
        else return ResponseEntity.status(400).body(new ApiResponse("Grade is not found"));
    }
    @DeleteMapping("/delete/{studentId}/{coureseId}")
    public ResponseEntity deleteGrade(@PathVariable String studentId , @PathVariable String coureseId ){

        if(gradesService.deleteGrade(studentId,coureseId))return ResponseEntity.ok(new ApiResponse("grade is deleted"));
        else return ResponseEntity.status(400).body(new ApiResponse("Grade is not found"));
    }
}
