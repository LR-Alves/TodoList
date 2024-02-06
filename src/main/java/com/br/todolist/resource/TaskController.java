package com.br.todolist.resource;


import com.br.todolist.model.Task;
import com.br.todolist.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/task" , produces = {"application/json"})
@Tag(name = "TodoList")
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



    @Operation(summary = "realizar a listagem de todas as tarefas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "listagem feira com sucesso"),
            @ApiResponse(responseCode = "422" , description = "dados de requisicao invalidos"),
            @ApiResponse(responseCode = "400", description = "parametros invalidos"),
            @ApiResponse(responseCode = "500" , description = "Erro ao realizar a busca das tarefas"),
    })
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskByid(id).map(task -> new ResponseEntity<>(task, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(summary = "realizar a listagem de todas as tarefas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "listagem feira com sucesso"),
            @ApiResponse(responseCode = "422" , description = "dados de requisicao invalidos"),
            @ApiResponse(responseCode = "400", description = "parametros invalidos"),
            @ApiResponse(responseCode = "500" , description = "Erro ao realizar a busca das tarefas"),
    })
    @PostMapping(value = "/{id}" , consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        taskService.addtask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        taskService.updateTask(id, updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> DeleteTask(@PathVariable Long id) {
        taskService.deletTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
