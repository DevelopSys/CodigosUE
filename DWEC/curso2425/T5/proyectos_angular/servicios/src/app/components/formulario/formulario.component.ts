import { Component } from '@angular/core';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-formulario',
  standalone: false,
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  nombre: string = '';
  apellido: string = '';
  edad: number = 0;
  fechaNacimiento: Date = new Date();

  constructor(private servicio: DataService) {}

  anadirUsuario() {
    let usuario = {
      nombre: this.nombre,
      apellido: this.apellido,
      edad: this.edad,
      fechaNacimiento: this.fechaNacimiento,
    };
    if (this.edad < 18) {
      alert('El usuario es menor de edad');
      return;
    } else {
      this.servicio.anadirUsuario(usuario); // llamar al servicio para añadir el usuario
      this.limpiarCampos();
    }
  }

  limpiarCampos() {
    this.nombre = '';
    this.apellido = '';
    this.edad = 0;
    this.fechaNacimiento = new Date();
  }
}
