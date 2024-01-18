package com.TodoList.service;


import com.TodoList.model.Task;
import com.TodoList.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateTask(Task updateTask) {
        taskRepository.save(updateTask);
    }

    public void deletTask(Long id) {
        taskRepository.deleteById(id);
        ;
    }
}
