package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Courses;
import com.example.lab7.Service.CoursesService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CoursesController {
    private final CoursesService coursesService;

    @GetMapping("/get")
    public ResponseEntity getcourses(){

        return ResponseEntity.ok(coursesService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addcourses(@RequestBody @Valid Courses courses , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        coursesService.addCourses(courses);
        return ResponseEntity.status(201).body(new ApiResponse("courses is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses(@PathVariable String id, @RequestBody @Valid Courses courses , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        if(coursesService.updateCourse(id,courses))return ResponseEntity.status(200).body(new ApiResponse("courses is updated"));
        else return ResponseEntity.status(400).body(new ApiResponse("courses not found"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourses(@PathVariable String id){


        if(coursesService.deleteCourse(id))return ResponseEntity.status(200).body(new ApiResponse("courses is deleted"));
        else return ResponseEntity.status(400).body(new ApiResponse("courses not found"));

    }
}
