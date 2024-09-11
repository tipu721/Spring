package com.example.reactivecrud.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Task")

public class Task {

    @Id
    private Integer id;
    private String title;
    private String description;
    private String status;
    private String dueDate;

}
