package com.TodoList.controller;


import com.TodoList.model.Task;
import com.TodoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskByid(id).map(task -> new ResponseEntity<>(task, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        taskService.addtask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@PathVariable Long id, Task updateTask) {
        updateTask.setId(id);
        taskService.updateTask(updateTask);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> DeleteTask(@PathVariable Long id) {
        taskService.deletTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
