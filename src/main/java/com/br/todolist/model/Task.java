package com.br.todolist.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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


