import { booleanAttribute, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../../services/taskservice';
import { Task } from '../../models/task';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-list.html',
  styleUrl: './task-list.scss'
})

export class TaskList implements OnInit{
  tasks: Task[] = [];
  newTaskTitle: string = '';
  newTaskMandatory: boolean = false; 
  newTaskDueDate: string = ''; 
  newTaskState: number = 0;  
  newTaskDescription: string = '';

  editingTask: Task | null = null;
  
  constructor(private taskService: TaskService) {
    
  }
   ngOnInit(): void {
    this.taskService.getTasks().subscribe(
      tasks => this.tasks = tasks,
      error => console.error('Error al obtener tareas:', error)
    );
  }

  getTasks(): void {
    this.taskService.getTasks().subscribe(
      tasks => this.tasks = tasks,
      error => console.error('Error al obtener tareas:', error)
    );
  }

   addTask(): void {
    if (this.newTaskTitle.trim()) {
      const newTask: Task = {
        title: this.newTaskTitle,
        mandatory: this.newTaskMandatory,
        duedate: new Date(this.newTaskDueDate), 
        state: this.newTaskState,
        description: this.newTaskDescription
      };

    this.taskService.addTask(newTask).subscribe(
        task => {
          this.tasks.push(task);
          this.newTaskTitle = '';
          this.newTaskMandatory = false;
          this.newTaskDueDate = '';
          this.newTaskState = 0;
          this.newTaskDescription = '';
        },
        error => console.error('Error al añadir tarea:', error)
      );
    }
  }

  editTask(task: Task): void {
    this.editingTask = { ...task };
  }

  saveEditedTask(): void {
    if (this.editingTask && this.editingTask.title.trim()) {
      this.taskService.updateTask(this.editingTask).subscribe(
        updatedTask => {
          const index = this.tasks.findIndex(t => t.id === updatedTask.id);
          if (index !== -1) {
            this.tasks[index] = updatedTask;
          }
          this.editingTask = null;
        },
        error => console.error('Error al actualizar tarea:', error)
      );
    }
  }

  deleteTask(id: string | undefined): void {
    if (id) {
      this.taskService.deleteTask(id).subscribe(
        () => {
          this.tasks = this.tasks.filter(task => task.id !== id);
        },
        error => console.error('Error al eliminar tarea:', error)
      );
    }
  }
}
