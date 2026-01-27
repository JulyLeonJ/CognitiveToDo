package org.example.infrastructure.adapter.repository;

import org.example.domain.model.Task;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.adapter.mapper.TaskMapper;
import org.example.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryJPA implements TaskRepository {

    private final TaskCRUDRepository taskCRUDRepository;
    private final TaskMapper taskMapper;

    public TaskRepositoryJPA(TaskCRUDRepository taskCRUDRepository, TaskMapper taskMapper) {
        this.taskCRUDRepository = taskCRUDRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        TaskEntity savedEntity = taskCRUDRepository.save(taskEntity);
        return taskMapper.toModel(savedEntity);
    }

    @Override
    public Task findById(String id) {
        return taskCRUDRepository.findById(id)
                .map(taskMapper::toModel)
                .orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return taskCRUDRepository.findAll().stream()
                .map(taskMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        taskCRUDRepository.deleteById(id);

    }
}
