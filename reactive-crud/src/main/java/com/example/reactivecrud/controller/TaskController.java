package com.example.reactivecrud.controller;
import com.example.reactivecrud.dto.Response;
import com.example.reactivecrud.dto.TaskDto;
import com.example.reactivecrud.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<TaskDto> saveTask(@RequestBody TaskDto taskDto) {
        return taskService.saveTask(taskDto);
    }

    @GetMapping
    public Flux<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }


    @PutMapping("/{id}")
    public Mono<TaskDto> updateEmployee(@RequestBody TaskDto taskDto, @PathVariable("id") Integer taskId) {
        return taskService.updateTask(taskDto, taskId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTask(@PathVariable("id") Integer id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/message")
    public Mono<Response> getMessage(){
        return taskService.getMessage();
    }


}
