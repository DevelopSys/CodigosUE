import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-detail',
  imports: [],
  templateUrl: './detail.html',
  styleUrl: './detail.css',
})
export class Detail {
  // recuperar el parametro pasado
  id: number = 0;
  tarea: tarea | undefined;

  constructor(
    private gestorRutas: ActivatedRoute,
    private servicio: Tareas,
  ) {
    this.gestorRutas.paramMap.subscribe((data) => {
      this.tarea = this.servicio.getTareaById(Number(data.get('id')) ?? 0);
    });
  }
}
