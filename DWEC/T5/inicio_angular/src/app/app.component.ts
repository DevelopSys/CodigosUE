import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  nombre: String = 'Borja Martin Herrera';
  asignatura: String = 'Desarrollo entorno cliente';
  logo = 'https://i.ytimg.com/vi/Wjj8fluz6rk/maxresdefault.jpg';
  contador = 0;

  ejecutarPulsacion(nombre: string) {
    this.contador++;
    this.nombre = nombre;
  }
}
