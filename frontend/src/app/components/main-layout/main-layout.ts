import {Component} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDrawerMode, MatSidenavModule} from '@angular/material/sidenav';
import { ProfileLayout } from '../profile-layout/profile-layout';
import {MatButtonModule} from '@angular/material/button';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'main-layout',
  templateUrl: 'main-layout.html',
  styleUrl: 'main-layout.scss',
  imports: [RouterOutlet, MatSidenavModule, MatButtonModule, FormsModule, ReactiveFormsModule, ProfileLayout],
})

export class MainLayout {
  protected mode = new FormControl<MatDrawerMode>('side');
}

