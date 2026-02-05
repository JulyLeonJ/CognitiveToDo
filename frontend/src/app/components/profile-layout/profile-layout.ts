import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressBarModule } from '@angular/material/progress-bar';

@Component({
  selector: 'profile-layout',
  imports: [MatIconModule, MatButtonModule, MatProgressBarModule],
  templateUrl: './profile-layout.html',
  styleUrl: './profile-layout.scss',
})
export class ProfileLayout {
  miAvatar = 'assets/chica-avatar.jpg';
}
