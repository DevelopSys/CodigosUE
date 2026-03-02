import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title: string = 'inicio';
  nombre: string = 'Borja';
  asignatura = 'Lenguaje de marcas';
  hora: number = 10;

  enviarDatos(nombre: string) {
    this.nombre = nombre;
  }
}
