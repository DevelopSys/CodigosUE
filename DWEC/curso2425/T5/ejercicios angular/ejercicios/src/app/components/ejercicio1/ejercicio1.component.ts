import { Component } from '@angular/core';

@Component({
  selector: 'app-ejercicio1',
  standalone: false,
  templateUrl: './ejercicio1.component.html',
  styleUrl: './ejercicio1.component.css',
})
export class Ejercicio1Component {
  nombre: string = '';
  edad: string = '';
  aceptar: any;
  opcion: string = '';

  mostrarDatos() {
    console.log('Nombre:', this.nombre);
    console.log('Edad:', this.edad);
    console.log('Opcion:', this.opcion);
    console.log('Aceptas:', this.aceptar);
  }
}
