import { Component } from '@angular/core';
import { UsurioIntefaz } from '../../model/Usuario';
import { UsuariosService } from '../../services/usuarios.service';

@Component({
  selector: 'app-alquiler',
  templateUrl: './alquiler.component.html',
  styleUrl: './alquiler.component.css',
})
export class AlquilerComponent {
  usuarios: UsurioIntefaz[] = [];

  constructor(private servicioUsuarios: UsuariosService) {
    this.usuarios = this.servicioUsuarios.getUsuarios();
  }
}
