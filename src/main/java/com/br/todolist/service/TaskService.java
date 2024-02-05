package com.br.todolist.service;


import com.br.todolist.exceptions.TaskNotFoundException;
import com.br.todolist.model.Task;
import com.br.todolist.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void addtask(Task task) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
//            String taskJson = objectMapper.writeValueAsString(task);
//            logger.info("tarefa criada: /n", taskJson);
            taskRepository.save(task);

        } catch (Exception e) {
            logger.error("log4j aqui: -- >", task);
            throw new RuntimeException("Erro ao adicionar a tarefa", e);
        }

    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskByid(Long id) {
        return taskRepository.findById(id);

    }

    public void saveTask(Task saveTask) {
        taskRepository.save(saveTask);
    }

public void updateTask(Long id, Task updateTask) {
        try {
            Task existingTask = taskRepository.getById(id);

            // Verificar se a descrição  e o status  fornecida e atualizar
            if (updateTask.getDescricao() != null)
                if (updateTask.isStatus()) {
                    existingTask.setDescricao(updateTask.getDescricao());
                }

            // Atualizar o status
            taskRepository.save(existingTask);
        } catch (EntityNotFoundException e) {
            throw new TaskNotFoundException(id);
        }
    }



    public void deletTask(Long id) {
        taskRepository.deleteById(id);
        ;
    }
}
