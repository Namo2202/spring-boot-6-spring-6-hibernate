package com.springboot.demo.rest;

import com.springboot.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Khaira", "Tasmia"));
        theStudents.add(new Student("Tahmid", "Mougamadou"));
        theStudents.add(new Student("Nafise", "Namo"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if ((studentId >= theStudents.size()) || (studentId < 0))
                throw  new StudentNotFoundException("Student id not found - "+ studentId);

        return theStudents.get(studentId);
    }

}
