package com.br.todolist.resource;


import com.br.todolist.model.Task;
import com.br.todolist.service.TaskService;
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

    @GetMapping("/status")
    public String status() {
        return "esta de pé";
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

    @PostMapping("/{add}")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        taskService.addtask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        taskService.updateTask(id, updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    @
            DeleteMapping("/{id}")
    public ResponseEntity<Task> DeleteTask(@PathVariable Long id) {
        taskService.deletTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
