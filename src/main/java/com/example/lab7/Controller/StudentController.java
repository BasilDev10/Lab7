package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){

        return ResponseEntity.ok(studentService.getStudentss());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("Student is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid Student student , Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        if(studentService.updateStudent(id,student))return ResponseEntity.status(200).body(new ApiResponse("Student is updated"));
        else return ResponseEntity.status(400).body(new ApiResponse("Student not found"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){


        if(studentService.deleteStudent(id))return ResponseEntity.status(200).body(new ApiResponse("Student is deleted"));
        else return ResponseEntity.status(400).body(new ApiResponse("Student not found"));

    }
}
