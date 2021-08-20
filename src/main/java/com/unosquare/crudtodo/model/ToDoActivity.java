package com.unosquare.crudtodo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_to_do")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activity;
    @Enumerated
    private STATUS_ENUM status;
}
