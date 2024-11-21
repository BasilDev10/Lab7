package com.example.lab7.Service;

import com.example.lab7.Model.Courses;
import com.example.lab7.Model.GradeScore;
import com.example.lab7.Model.Grades;
import com.example.lab7.Model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();
    private final CoursesService coursesService;
    private final GradesService gradesService;

    private static int counter = 0;

    public ArrayList<Student> getStudentss(){
        return students;
    }

    public Student getStudentById(String id){
        for (Student student : students){
            if (student.getId().equalsIgnoreCase(id)) return student;
        }
        return null;
    }
    public void addStudent(Student student){

        ArrayList<Courses> courses = coursesService.getCourses();
        ArrayList<Courses> updatedCourses = new ArrayList<>();
        for (Courses c : courses){

            c.getGrades().add(gradesService.addGreade(new Grades( "GR"+counter,0,"NotFinished",c,student,null)));
            counter++;
            updatedCourses.add(c);
        }
        student.setCourses(updatedCourses);
        students.add(student);

    }

    public boolean updateStudent(String id , Student student){

        for (int i = 0; i < students.size() ; i++){
            if(students.get(i).getId().equalsIgnoreCase(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id ){

        for (int i = 0; i < students.size() ; i++){
            if(students.get(i).getId().equalsIgnoreCase(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

}
