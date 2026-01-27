package org.example.domain.repository;

import org.example.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Task findById(String id);
    List<Task> findAll();
    void deleteById(String id);
}
