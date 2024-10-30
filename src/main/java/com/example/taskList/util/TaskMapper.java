package com.example.taskList.util;

import com.example.taskList.peristence.entity.TaskEntity;
import com.example.taskList.presentation.dto.TaskRequest;
import com.example.taskList.presentation.dto.TaskResponse;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper {

    public List<TaskResponse> getListTask(List<TaskEntity> taskEntity){
        return taskEntity.stream()
                .map(p -> new TaskResponse(
                        p.getId(),
                        p.getDescription(),
                        p.getDate(),
                        p.getLimitDate(),
                        p.getFinished()
                ))
                .toList();
    }

    public TaskResponse getTask(TaskEntity taskEntity){
        return new TaskResponse(
                taskEntity.getId(),
                taskEntity.getDescription(),
                taskEntity.getDate(),
                taskEntity.getLimitDate(),
                taskEntity.getFinished()
        );
    }

    public TaskEntity getRequestToEntity(TaskRequest taskRequest){
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setDescription(taskRequest.description());
        taskEntity.setDate(taskRequest.date());
        taskEntity.setLimitDate(taskRequest.limitDate());
        taskEntity.setFinished(taskRequest.finished());

        return taskEntity;
    }

    public TaskEntity getUpdateTask(TaskRequest taskRequest, TaskEntity taskEntity){
        if (StringUtils.isNotEmpty(taskRequest.description())){
            taskEntity.setDescription(taskRequest.description());
        }

        if (StringUtils.isNotEmpty(String.valueOf(taskRequest.date()))){
            taskEntity.setDate(taskRequest.date());
        }

        if (StringUtils.isNotEmpty(String.valueOf(taskRequest.limitDate()))){
            taskEntity.setLimitDate(taskRequest.limitDate());
        }

        if (StringUtils.isNotEmpty(String.valueOf(taskRequest.finished()))){
            taskEntity.setFinished(taskRequest.finished());
        }

        return taskEntity;
    }
}



