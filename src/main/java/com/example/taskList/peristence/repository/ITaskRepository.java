package com.example.taskList.peristence.repository;

import com.example.taskList.peristence.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends ListCrudRepository<TaskEntity, Long> {
}
