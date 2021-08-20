package com.unosquare.crudtodo.repository;

import com.unosquare.crudtodo.model.STATUS_ENUM;
import com.unosquare.crudtodo.model.ToDoActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoActivity, Long> {
    public List<ToDoActivity> findByStatus(STATUS_ENUM status);

}
