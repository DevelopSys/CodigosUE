import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  private tareas: tarea[] = [];
  private contador: number = 0;

  addTarea(tarea: tarea) {
    this.contador++;
    tarea.id = this.contador;
    this.tareas.push(tarea);
  }

  getAll(): tarea[] {
    return this.tareas;
  }

  getAllByReponsable(responsable: string): tarea[] {
    return this.tareas.filter((data) => data.responsable == responsable);
  }

  getTareaById(id: number): tarea | undefined {
    return this.tareas.find((item) => (item.id = id));
  }
}
