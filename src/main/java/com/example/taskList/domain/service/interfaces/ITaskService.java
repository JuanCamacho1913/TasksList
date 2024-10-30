package com.example.taskList.domain.service.interfaces;

import com.example.taskList.presentation.dto.TaskRequest;
import com.example.taskList.presentation.dto.TaskResponse;

import java.util.List;

public interface ITaskService {

    List<TaskResponse> findAllTask();

    TaskResponse findById(Long id);

    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    void deleteTaskById(Long id);
}
