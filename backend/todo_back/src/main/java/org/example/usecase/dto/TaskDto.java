package org.example.usecase.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class TaskDto {
    String id;
    boolean mandatory;
    String title;
    int state;
    LocalDate dueDate;
    String description;

}
