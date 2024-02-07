package com.br.todolist.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "tasks")
public class Task {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String descricao;
 private LocalDate dataCriacao ;
 private boolean status ;



}


