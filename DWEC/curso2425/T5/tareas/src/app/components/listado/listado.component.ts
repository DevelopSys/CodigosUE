import { Component, Input } from '@angular/core';
import { Conocimiento } from '../../model/modelos';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  nombre = 'Borja';
  nombreConocimineto = '';
  nivelConocimiento = '';
  conocimientos: Conocimiento[] = [];
  mostrar = false;
  ruta = '../../assets/imagenweb.jpg';
  url =
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwhFNGv9UvSO3RW0hpy2WCoZ1Q2PJ1zmqHZg&s';

  guardarElemento() {
    if (
      this.nombreConocimineto.length == 0 &&
      this.nivelConocimiento.length == 0
    ) {
      // alert('Faltan datos');
      Swal.fire({
        title: 'Fallo',
        text: 'Faltan datos por rellenar',
        icon: 'warning',
      });
    } else {
      let conocimiento: Conocimiento = {
        nombre: this.nombreConocimineto,
        nivel: this.nivelConocimiento,
      };

      this.conocimientos.push(conocimiento);
      this.vaciarDatos();
    }
  }

  mostrarConocimientos() {
    this.mostrar = !this.mostrar;
  }

  vaciarDatos() {
    this.nombreConocimineto = '';
    this.nivelConocimiento = '';
  }
}
