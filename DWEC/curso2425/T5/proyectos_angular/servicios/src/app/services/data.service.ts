import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private usuarios: Usuario[] = [];
  constructor() {}

  public anadirUsuario(usuario: Usuario) {
    this.usuarios.push(usuario);
  }

  public obtenerUsuarios(): Usuario[] {
    return this.usuarios;
  }
}
