package com.br.todolist.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String descicao;
 private LocalDate dataCriacao ;
 private boolean status ;



}


