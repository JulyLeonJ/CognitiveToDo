package org.example.usecase.service;

import org.example.domain.model.Task;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.adapter.mapper.TaskMapper;
import org.example.infrastructure.adapter.repository.TaskRepositoryJPA;
import org.example.usecase.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepositoryJPA taskRepositoryJPA, TaskMapper taskMapper) {
        this.taskRepository = taskRepositoryJPA;
        this.taskMapper = taskMapper;
    }

    public TaskDto CreateTask(TaskDto taskDto){
        Task taskToSave = taskMapper.toDomain(taskDto);

        Task savedTask = taskRepository.save(taskToSave);
        return taskMapper.toDto(savedTask);
    }

    public TaskDto getTaskById(String id) throws ClassNotFoundException {
        Task task = taskRepository.findById(id);
        if(task == null){
            throw new TaskNotFoundException("Tarea con id" + id + "no se encontró");
        }
        return taskMapper.toDto(task);
    }

    public List<TaskDto> getAllTasks(){
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskDto updateTask(String id, TaskDto taskDto){
        Task existingTask = taskRepository.findById(id);
        if (existingTask == null){
            throw new TaskNotFoundException("Tarea con id" + id + "no se encontró");
        }
        Task updateTaskDomain = new Task(
                existingTask.getId(),
                taskDto.isMandatory(),
                taskDto.getTitle(),
                taskDto.getState(),
                taskDto.getDueDate(),
                taskDto.getDescription()
                );

        Task savedTask = taskRepository.save(updateTaskDomain);
        return taskMapper.toDto(savedTask);
    }

    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }

    public static class TaskNotFoundException extends RuntimeException{
        public TaskNotFoundException(String message){
            super(message);
        }
    }


}
