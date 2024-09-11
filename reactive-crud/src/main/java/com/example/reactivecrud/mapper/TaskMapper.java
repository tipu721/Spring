package com.example.reactivecrud.mapper;
import com.example.reactivecrud.dto.TaskDto;
import com.example.reactivecrud.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate()
        );
    }

    public static Task mapToTask(TaskDto taskDto){
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getStatus(),
                taskDto.getDueDate()
        );
    }

}
