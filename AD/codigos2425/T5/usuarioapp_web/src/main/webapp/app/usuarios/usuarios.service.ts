import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { UsuariosDTO } from 'app/usuarios/usuarios.model';


@Injectable({
  providedIn: 'root',
})
export class UsuariosService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/usuarioss';

  getAllUsuarioses() {
    return this.http.get<UsuariosDTO[]>(this.resourcePath);
  }

  getUsuarios(id: number) {
    return this.http.get<UsuariosDTO>(this.resourcePath + '/' + id);
  }

  createUsuarios(usuariosDTO: UsuariosDTO) {
    return this.http.post<number>(this.resourcePath, usuariosDTO);
  }

  updateUsuarios(id: number, usuariosDTO: UsuariosDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, usuariosDTO);
  }

  deleteUsuarios(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

}
