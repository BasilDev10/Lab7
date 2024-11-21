package com.example.lab7.Service;

import com.example.lab7.Model.Courses;
import com.example.lab7.Model.Grades;
import com.example.lab7.Model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GradesService {
    ArrayList<Grades> grades = new ArrayList<>();
//    private final StudentService studentService;
 //   private final CoursesService coursesService;


    public ArrayList<Grades> getGrades(){
        return grades;
    }

    public Grades addGreade(Grades grade){

        grades.add(grade);
        return grade;
    }
//    public Grades addGreade(String studentId ,String coursesId, Grades grade){
//
//        Student student = studentService.getStudentById(studentId);
//        Courses course = coursesService.getCoursesById(coursesId);
//        if (student == null || course == null )return null;
//        grade.setStudent(student);
//        grade.setCourses(course);
//        grades.add(grade);
//        return grade;
//    }

    public boolean updateGrade(String studentId , String coureseId , Grades grade){

        for (int i = 0 ; i < grades.size(); i++){
            if (grades.get(i).getStudent().getId().equalsIgnoreCase(studentId) && grades.get(i).getCourses().getId().equalsIgnoreCase(coureseId)){
                grades.set(i,grade);
                return true;
            }
        }
        return false;
    }
    public boolean deleteGrade(String studentId , String coureseId ){

        for (int i = 0 ; i < grades.size(); i++){
            if (grades.get(i).getStudent().getId().equalsIgnoreCase(studentId) && grades.get(i).getCourses().getId().equalsIgnoreCase(coureseId)){
                grades.remove(i);
                return true;
            }
        }
        return false;
    }
}
