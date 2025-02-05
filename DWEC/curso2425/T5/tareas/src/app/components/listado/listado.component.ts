import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  elementos = ['uno', 'dos', 'tres', 'cuatro'];
}
