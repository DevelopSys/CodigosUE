import { Component } from '@angular/core';
import { UsuarioClase, UsurioIntefaz } from '../../model/Usuario';
import { UsuariosService } from '../../services/usuarios.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css',
})
export class RegistroComponent {
  nombre: string = '';
  apellido: string = '';
  telefono: string = '';
  password: string = '';

  constructor(private servicioUsuarios: UsuariosService) {}

  registrarUsuario() {
    // nombre, correo, pass, tel
    /* let usuario: UsuarioClase = new UsuarioClase(
      this.nombre,
      this.apellido,
      Number(this.telefono),
      this.password
    ); */

    let usuarioInterfaz: UsurioIntefaz = {
      nombre: this.nombre,
      apellido: this.apellido,
      telefono: Number(this.telefono),
      pass: this.password,
    };

    this.servicioUsuarios.addUsuario(usuarioInterfaz);

    this.apellido = '';
    this.nombre = '';
    this.telefono = '';
    this.password = '';
  }
}
