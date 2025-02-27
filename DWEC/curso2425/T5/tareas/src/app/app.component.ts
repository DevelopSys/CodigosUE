import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  autor = 'Borja Martin';
  asignatura = 'Desarrollo cliente';
  seleccion = 4;
  /* fecha = new Date() */

  constructor(private router: Router) {}

  navegar() {
    console.log('Proceso a navegar');
    this.router.navigate(['listado', this.seleccion]);
  }
}
