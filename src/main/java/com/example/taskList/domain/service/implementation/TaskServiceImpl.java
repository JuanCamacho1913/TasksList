package com.example.taskList.domain.service.implementation;

import com.example.taskList.domain.exception.TaskNotFoundException;
import com.example.taskList.domain.service.interfaces.ITaskService;
import com.example.taskList.peristence.entity.TaskEntity;
import com.example.taskList.peristence.repository.ITaskRepository;
import com.example.taskList.presentation.dto.TaskRequest;
import com.example.taskList.presentation.dto.TaskResponse;
import com.example.taskList.util.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;


    @Override
    public List<TaskResponse> findAllTask() {
        List<TaskEntity> taskEntityList = this.taskRepository.findAll();

        return this.taskMapper.getListTask(taskEntityList);
    }

    @Override
    public TaskResponse findById(Long id) {
        TaskEntity taskEntity = this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(String.format("Id not found")));

        return this.taskMapper.getTask(taskEntity);
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        TaskEntity taskEntity = this.taskMapper.getRequestToEntity(taskRequest);
        TaskEntity taskEntityCreate = this.taskRepository.save(taskEntity);

        return this.taskMapper.getTask(taskEntityCreate);
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        TaskEntity taskEntityById = this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(String.format("Id not found", id)));

        TaskEntity taskEntity = this.taskMapper.getUpdateTask(taskRequest, taskEntityById);
        TaskEntity taskEntitySave = this.taskRepository.save(taskEntity);

        return this.taskMapper.getTask(taskEntitySave);
    }

    @Override
    public void deleteTaskById(Long id) {
        this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(String.format("Id not found")));

        this.taskRepository.deleteById(id);
    }
}
