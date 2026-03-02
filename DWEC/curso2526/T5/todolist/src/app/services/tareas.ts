import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  private tareas: tarea[] = [];

  addTarea(tarea: tarea) {
    this.tareas.push(tarea);
  }

  getAll(): tarea[] {
    return this.tareas;
  }

  getAllByReponsable(responsable: string): tarea[] {
    return this.tareas.filter((data) => data.responsable == responsable);
  }
}
