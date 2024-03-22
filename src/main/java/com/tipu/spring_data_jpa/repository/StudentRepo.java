package com.tipu.spring_data_jpa.repository;

import com.tipu.spring_data_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByAge(Integer age);
}
