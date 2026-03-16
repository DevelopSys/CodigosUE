import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';
import { ImagenesPipe } from '../../pipes/imagenes-pipe';
import { CardItem } from '../shared/card-item/card-item';

@Component({
  selector: 'app-list',
  imports: [CommonModule, FormsModule, CardItem],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  tareas: tarea[] = [];

  constructor(private servicio: Tareas) {
    this.tareas = this.servicio.getAll();
  }
}
