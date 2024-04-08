package com.tipu.spring_rest.repository;

import com.tipu.spring_rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    //Query DSL
    List<Student> findByAgeOrderByName(Integer age);
}
