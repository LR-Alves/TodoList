package com.TodoList.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@Getter
@Setter
public class Task {


 private Long id;
 private String descicao;
 private LocalDate dataCriacao ;
 private boolean status ;



}


