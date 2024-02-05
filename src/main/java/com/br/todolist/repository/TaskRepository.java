package com.br.todolist.repository;

import com.br.todolist.model.Task;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
