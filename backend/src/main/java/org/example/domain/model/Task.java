package org.example.domain.model;
import lombok.Value;


import java.time.LocalDate;

@Value
public class Task {
    String id;
    boolean mandatory;
    String title;
    int state;
    LocalDate dueDate;
    String description;


    public Task(String id, boolean mandatory, String title, int state, LocalDate dueDate, String description) {
        this.id = id;
        this.mandatory = mandatory;
        this.title = title;
        this.state = state;
        this.dueDate = dueDate;
        this.description = description;
    }
}
