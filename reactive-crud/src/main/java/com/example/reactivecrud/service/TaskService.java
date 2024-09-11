package com.example.reactivecrud.service;

import com.example.reactivecrud.dto.Response;
import com.example.reactivecrud.dto.TaskDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {

    
    Mono<TaskDto> saveTask(TaskDto taskDto);

    Flux<TaskDto> getAllTasks();

    Mono<TaskDto> updateTask(TaskDto taskDto, Integer taskId);

    Mono<Void> deleteTask(Integer id);

    Mono<Response> getMessage();
}
