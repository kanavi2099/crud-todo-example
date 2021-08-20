package com.unosquare.crudtodo.controller;

import com.unosquare.crudtodo.model.STATUS_ENUM;
import com.unosquare.crudtodo.model.ToDoActivity;
import com.unosquare.crudtodo.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class CRUDController {
    public final CRUDService crudService;

    @PostMapping("/task")
    public String createTask(@RequestBody ToDoActivity activity){
        return crudService.create(activity);
    }
    @PutMapping("/task")
    public String updateTask(@RequestBody ToDoActivity activity){
        return crudService.updateTask(activity);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return crudService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public ToDoActivity getById(@PathVariable Long id){
        return crudService.findActivityById(id);
    }

    @GetMapping("/task/{status}")
    public List<ToDoActivity> getByStatus(@PathVariable String status){
        STATUS_ENUM value=STATUS_ENUM.valueOf(status);
        return crudService.getActivitiesByStatus(value);
    }

    @GetMapping
    public List<ToDoActivity> getAll(){
        return crudService.getActivities();
    }


}
