package com.tipu.spring_data_jpa.controller;

import com.tipu.spring_data_jpa.model.Student;
import com.tipu.spring_data_jpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}
