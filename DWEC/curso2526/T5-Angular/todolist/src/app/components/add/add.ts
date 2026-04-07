import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-add',
  imports: [CommonModule, FormsModule],
  templateUrl: './add.html',
  styleUrl: './add.css',
})
export class Add {
  dificultad?: string | undefined;
  nombre?: string;
  responsable?: string;
  definicion?: string;
  fecha?: string;
  complemento?: string;

  constructor(private servicio: Tareas) {}

  anadirTarea() {
    // validar los datos
    this.servicio.addTarea({
      id: -1,
      nombre: this.nombre!!,
      responsable: this.responsable!!,
      fecha: this.fecha!!,
      descripcion: this.definicion!!,
      complemento: this.complemento!!,
      prioridad: Number(this.dificultad),
    });
  }
}
