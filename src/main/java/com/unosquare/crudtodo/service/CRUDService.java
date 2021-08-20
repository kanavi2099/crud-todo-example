package com.unosquare.crudtodo.service;

import com.unosquare.crudtodo.model.STATUS_ENUM;
import com.unosquare.crudtodo.model.ToDoActivity;

import java.util.List;

public interface CRUDService {
    String create(ToDoActivity activity);
    List<ToDoActivity> getActivities();
    List<ToDoActivity> getActivitiesByStatus(STATUS_ENUM status);
    ToDoActivity findActivityById(Long id);
    String updateTask(ToDoActivity activity);
    String deleteTask(Long id);
}
