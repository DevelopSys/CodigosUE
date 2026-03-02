import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';
import { ImagenesPipe } from '../../pipes/imagenes-pipe';

@Component({
  selector: 'app-list',
  imports: [CommonModule, FormsModule, ImagenesPipe],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  tareas: tarea[] = [];

  constructor(private servicio: Tareas) {
    this.tareas = this.servicio.getAll();
  }
}
