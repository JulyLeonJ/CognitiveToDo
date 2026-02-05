import { Component } from '@angular/core';
import { MainLayout } from './components/main-layout/main-layout';
import { TaskList } from './components/task-list/task-list';

@Component({
  selector: 'app-root',
  imports: [MainLayout, TaskList],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'frontend';
}
