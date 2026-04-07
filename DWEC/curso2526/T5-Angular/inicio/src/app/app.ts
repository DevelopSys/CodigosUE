import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('inicio');
  nombre?: string | undefined = 'Borja'; // string | undefined
  nota?: number | undefined = 10; // number | undefined
  imagen = 'https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg';

  procesarRespuesta(nombre: string, nota: string) {
    this.nombre = nombre;
    this.nota = Number(nota);
    if (this.nota < 5) {
      this.imagen = 'https://i.pinimg.com/originals/f8/a8/c2/f8a8c206faf16a20f76b53e020f96fd0.jpg';
    } else {
      this.imagen = 'https://i.pinimg.com/474x/1f/ff/d7/1fffd76958c68a8d7cb7e98bbaeda1bc.jpg';
    }
  }
}
