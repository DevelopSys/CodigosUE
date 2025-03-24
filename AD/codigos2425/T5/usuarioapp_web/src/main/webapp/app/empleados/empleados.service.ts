import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { EmpleadosDTO } from 'app/empleados/empleados.model';
import { map } from 'rxjs';
import { transformRecordToMap } from 'app/common/utils';


@Injectable({
  providedIn: 'root',
})
export class EmpleadosService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/empleadoss';

  getAllEmpleadoses() {
    return this.http.get<EmpleadosDTO[]>(this.resourcePath);
  }

  getEmpleados(id: number) {
    return this.http.get<EmpleadosDTO>(this.resourcePath + '/' + id);
  }

  createEmpleados(empleadosDTO: EmpleadosDTO) {
    return this.http.post<number>(this.resourcePath, empleadosDTO);
  }

  updateEmpleados(id: number, empleadosDTO: EmpleadosDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, empleadosDTO);
  }

  deleteEmpleados(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

  getIdPerfilValues() {
    return this.http.get<Record<string, number>>(this.resourcePath + '/idPerfilValues')
        .pipe(map(transformRecordToMap));
  }

}
