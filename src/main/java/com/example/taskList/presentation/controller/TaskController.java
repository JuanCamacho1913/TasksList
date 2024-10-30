package com.example.taskList.presentation.controller;

import com.example.taskList.domain.service.implementation.TaskServiceImpl;
import com.example.taskList.domain.service.interfaces.ITaskService;
import com.example.taskList.presentation.dto.TaskRequest;
import com.example.taskList.presentation.dto.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    @GetMapping("/findAll")
    public ResponseEntity<List<TaskResponse>> findAllTask(){
        return new ResponseEntity<>(this.taskService.findAllTask(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest taskRequest){
        return new ResponseEntity<>(this.taskService.createTask(taskRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody @Valid TaskRequest taskRequest, @PathVariable Long id){
        return new ResponseEntity<>(this.taskService.updateTask(taskRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        this.taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}















