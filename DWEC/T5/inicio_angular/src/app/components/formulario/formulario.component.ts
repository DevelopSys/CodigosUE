import { Component } from '@angular/core';
import { Usuario } from '../../model/usuario';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  listaUsuarios: Usuario[] = [];
  nombreN: string = '';
  apellidoA: string = '';
  telefonoT: string = '';
  dniD: string = '';

  agregarUsuario() {
    /* si intento agregar un uusario con un dni ya exitente ma das fallo, sino lo agregar */

    let usuarioBuscar = this.listaUsuarios.find((item: Usuario) => {
      return item.dni == this.dniD;
    });

    if (usuarioBuscar == null) {
      this.listaUsuarios.push({
        nombre: this.nombreN,
        apellido: this.apellidoA,
        dni: this.dniD,
        telefono: Number(this.telefonoT),
      });

      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Usuario agregaro correctamente',
        showConfirmButton: false,
        timer: 1000,
      });
    } else {
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Usuario ya existente en bd',
        showConfirmButton: false,
        timer: 1500,
      });
    }

    this.nombreN = '';
    this.apellidoA = '';
    this.telefonoT = '';
    this.dniD = '';
    //console.log(this.listaUsuarios);
  }
}
