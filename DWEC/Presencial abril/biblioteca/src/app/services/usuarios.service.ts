import { Injectable } from '@angular/core';
import { UsuarioClase, UsurioIntefaz } from '../model/Usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuariosService {
  // el array de usuarios

  usuarios: UsurioIntefaz[] = [];
  constructor() {}

  addUsuario(usuario: UsurioIntefaz) {
    this.usuarios.push(usuario);
  }

  getUsuarios(): UsurioIntefaz[] {
    return this.usuarios;
  }
}
