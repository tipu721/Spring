package com.example.reactivecrud.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Integer id;
    private String title;
    private String description;
    private String status;
    private String dueDate;
}
