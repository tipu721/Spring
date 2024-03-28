package com.tipu.spring_rest.controller;

import com.tipu.spring_rest.exception.UserNotFoundException;
import com.tipu.spring_rest.model.Student;
import com.tipu.spring_rest.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;


    @PostMapping("/student")
    Student save(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping("/findByAge")
    List<Student> findByAge(@RequestParam Integer age){
        return studentRepo.findByAgeOrderByName(age);
    }

    @GetMapping("/student/{id}")
    Optional<Student> findById(@PathVariable Long id){
        Optional<Student> student = studentRepo.findById(id);

        return student;
    }
}
