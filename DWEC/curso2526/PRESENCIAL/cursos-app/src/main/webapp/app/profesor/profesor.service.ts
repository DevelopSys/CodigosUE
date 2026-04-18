import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { ProfesorDTO } from 'app/profesor/profesor.model';
import { map } from 'rxjs';
import { transformRecordToMap } from 'app/common/utils';


@Injectable({
  providedIn: 'root',
})
export class ProfesorService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/profesors';

  getAllProfesors() {
    return this.http.get<ProfesorDTO[]>(this.resourcePath);
  }

  getProfesor(id: number) {
    return this.http.get<ProfesorDTO>(this.resourcePath + '/' + id);
  }

  createProfesor(profesorDTO: ProfesorDTO) {
    return this.http.post<number>(this.resourcePath, profesorDTO);
  }

  updateProfesor(id: number, profesorDTO: ProfesorDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, profesorDTO);
  }

  deleteProfesor(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

  getIdCursoFKValues() {
    return this.http.get<Record<string, string>>(this.resourcePath + '/idCursoFKValues')
        .pipe(map(transformRecordToMap));
  }

}
