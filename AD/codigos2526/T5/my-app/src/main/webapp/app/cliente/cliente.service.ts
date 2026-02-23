import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { ClienteDTO } from 'app/cliente/cliente.model';
import { map } from 'rxjs';
import { transformRecordToMap } from 'app/common/utils';


@Injectable({
  providedIn: 'root',
})
export class ClienteService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/clientes';

  getAllClientes() {
    return this.http.get<ClienteDTO[]>(this.resourcePath);
  }

  getCliente(id: number) {
    return this.http.get<ClienteDTO>(this.resourcePath + '/' + id);
  }

  createCliente(clienteDTO: ClienteDTO) {
    return this.http.post<number>(this.resourcePath, clienteDTO);
  }

  updateCliente(id: number, clienteDTO: ClienteDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, clienteDTO);
  }

  deleteCliente(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

  getProductosValues() {
    return this.http.get<Record<string, number>>(this.resourcePath + '/productosValues')
        .pipe(map(transformRecordToMap));
  }

}
