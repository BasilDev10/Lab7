package com.example.lab7.Service;

import com.example.lab7.Model.Courses;
import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CoursesService {

    ArrayList<Courses> courses = new ArrayList<>();

    
    public CoursesService(){
        courses.add(new Courses("CO111","Java",4,new ArrayList<>()));
        courses.add(new Courses("CO222","C#",4,new ArrayList<>()));
        courses.add(new Courses("CO333","Sql",3,new ArrayList<>()));
        courses.add(new Courses("CO444","Html",2,new ArrayList<>()));
        courses.add(new Courses("CO555","AI",4,new ArrayList<>()));
        
    }

    public ArrayList<Courses> getCourses(){
        return courses;
    }

    public Courses getCoursesById(String id){
        for (Courses course : courses){
            if (course.getId().equalsIgnoreCase(id)) return course;
        }
        return null;
    }
    public void addCourses(Courses course){

        courses.add(course);

    }

    public boolean updateCourse(String id , Courses course){

        for (int i = 0; i < courses.size() ; i++){
            if(courses.get(i).getId().equalsIgnoreCase(id)){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id ){

        for (int i = 0; i < courses.size() ; i++){
            if(courses.get(i).getId().equalsIgnoreCase(id)){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
}
