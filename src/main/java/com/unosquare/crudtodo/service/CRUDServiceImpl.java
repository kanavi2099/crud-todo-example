package com.unosquare.crudtodo.service;

import com.unosquare.crudtodo.model.STATUS_ENUM;
import com.unosquare.crudtodo.model.ToDoActivity;
import com.unosquare.crudtodo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CRUDServiceImpl implements CRUDService{
    private final ToDoRepository toDoRepository;

    @Override
    public String create(ToDoActivity activity) {
        toDoRepository.save(activity);
        return "Task Created with id: "+activity.getId();
    }

    @Override
    public List<ToDoActivity> getActivities() {
        return toDoRepository.findAll();
    }

    @Override
    public List<ToDoActivity> getActivitiesByStatus(STATUS_ENUM status) {
        return toDoRepository.findByStatus(status);
    }

    @Override
    public ToDoActivity findActivityById(Long id) {
        return toDoRepository.findById(id).orElseGet(()->null);
    }

    @Override
    public String updateTask(ToDoActivity activity) {
        ToDoActivity task = toDoRepository.findById(activity.getId())
                .orElseGet(()->null);
        if(task==null)
            return "No Task found, check your information";
        toDoRepository.save(activity);
        return "Task Updated!";
    }

    @Override
    public String deleteTask(Long id) {
        ToDoActivity task = toDoRepository.findById(id)
                .orElseGet(()->null);
        if(task==null)
            return "No Task found, check your information";
        toDoRepository.deleteById(id);
        return "Task deleted...";
    }
}
