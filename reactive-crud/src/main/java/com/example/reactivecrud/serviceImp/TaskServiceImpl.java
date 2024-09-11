package com.example.reactivecrud.serviceImp;

import com.example.reactivecrud.dto.Response;
import com.example.reactivecrud.dto.TaskDto;
import com.example.reactivecrud.entity.Task;
import com.example.reactivecrud.mapper.TaskMapper;
import com.example.reactivecrud.repository.TaskRepository;
import com.example.reactivecrud.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final WebClient webClient;

    @Override
    public Mono<Response> getMessage() {
        Mono<Response> responseMono = this.webClient.get().uri("/message").retrieve().bodyToMono(Response.class);
        return responseMono;
    }

    @Override
    public Mono<TaskDto> saveTask(TaskDto taskDto) {

        Task task = TaskMapper.mapToTask(taskDto);
        Mono<Task> savedTask = taskRepository.save(task);
        return savedTask.map(TaskMapper::mapToTaskDto);

    }

    @Override
    public Flux<TaskDto> getAllTasks() {

        Flux<Task> taskDtoFlux = taskRepository.findAll();
        return taskDtoFlux.map(TaskMapper::mapToTaskDto).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<TaskDto> updateTask(TaskDto taskDto, Integer taskId) {
        Mono<Task> taskMono = taskRepository.findById(taskId);
        return taskMono.flatMap((existingTask) -> {
            existingTask.setTitle(taskDto.getTitle());
            existingTask.setDescription(taskDto.getDescription());
            existingTask.setStatus(taskDto.getStatus());
            existingTask.setDueDate(taskDto.getDueDate());
            return taskRepository.save(existingTask);
        }).map(TaskMapper::mapToTaskDto);

    }

    @Override
    public Mono<Void> deleteTask(Integer id) {
        return taskRepository.deleteById(id);
    }


}
