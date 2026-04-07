import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Tareas } from '../../services/tareas';
import { tarea } from '../../model/tarea';
import { CardItem } from '../shared/card-item/card-item';

@Component({
  selector: 'app-search',
  imports: [FormsModule, CardItem],
  templateUrl: './search.html',
  styleUrl: './search.css',
})
export class Search {
  responsable?: string;
  tareas: tarea[] = [];
  procesado = false;

  constructor(private servicio: Tareas) {}

  buscar() {
    // comprobar datos
    this.tareas = this.servicio.getAllByReponsable(this.responsable!!);
    this.procesado = true;
  }
}
