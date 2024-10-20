import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seleccion',
  templateUrl: './seleccion.component.html',
  styleUrl: './seleccion.component.css',
})
export class SeleccionComponent {
  seleccionVista = '';
  seleccionCategoria = '';

  constructor(private rutas: Router) {
    /* traer el modulo Router */
  }

  navegar() {
    /* Router -> navigate */
    this.rutas.navigate(['productos', this.seleccionCategoria]);
    // productos
  }
}
