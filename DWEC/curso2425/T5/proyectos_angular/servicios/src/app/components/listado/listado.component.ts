import { Component } from '@angular/core';
import { Usuario } from '../../model/usuario';
import { DataService } from '../../services/data.service';
import { UserAPI } from '../../model/usuarioAPI';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  usuarios?: Usuario[];
  usuariosURL?: UserAPI[];

  constructor(
    private usuarioService: DataService,
    private apiService: ApiService
  ) {
    this.usuarios = this.usuarioService.obtenerUsuarios();
    apiService.getAllUsers().subscribe((data) => {
      // ejecutado en el momento que se recibe la respuesta y posibles cambios en ella
      this.usuariosURL = data.users;
    });
  }
}
