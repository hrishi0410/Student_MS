package com.crud.project1.StudentController;

import com.crud.project1.StudentRepo.StudentRepo;
import com.crud.project1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        List<Student> list=repo.findAll();
        return list;
    }
    //get data(student data) by id.
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student1=repo.findById(id).get();
        return student1;
    }
    //add data(student)
    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        repo.delete(student);

    }
}
