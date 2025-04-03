import { Component } from '@angular/core';

@Component({
  selector: 'app-ejercicio2',
  standalone: false,
  templateUrl: './ejercicio2.component.html',
  styleUrl: './ejercicio2.component.css',
})
export class Ejercicio2Component {
  mostrar: boolean = false;
  edad: number = 0;
  rol: any;
  mensaje: string = '';

  validarDatos() {
    // this.mostrar = !this.mostrar;
    /* if (this.edad >= 18) {
      this.mostrar = false;
    } else {
      this.mostrar = true;
    } */
    switch (this.rol) {
      case '0':
        this.mensaje = 'Bienvenido Admin';
        break;

      case '1':
        this.mensaje = 'Bienvenido Invitado';
        break;

      case '1':
        this.mensaje = 'Bienvenido Editor';
        break;
      default:
        break;
    }
  }
}
