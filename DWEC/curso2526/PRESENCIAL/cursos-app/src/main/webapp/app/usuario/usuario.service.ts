import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { UsuarioDTO } from 'app/usuario/usuario.model';
import { map } from 'rxjs';
import { transformRecordToMap } from 'app/common/utils';


@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/usuarios';

  getAllUsuarios() {
    return this.http.get<UsuarioDTO[]>(this.resourcePath);
  }

  getUsuario(id: number) {
    return this.http.get<UsuarioDTO>(this.resourcePath + '/' + id);
  }

  createUsuario(usuarioDTO: UsuarioDTO) {
    return this.http.post<number>(this.resourcePath, usuarioDTO);
  }

  updateUsuario(id: number, usuarioDTO: UsuarioDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, usuarioDTO);
  }

  deleteUsuario(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

  getIdCursoFKValues() {
    return this.http.get<Record<string, string>>(this.resourcePath + '/idCursoFKValues')
        .pipe(map(transformRecordToMap));
  }

}
