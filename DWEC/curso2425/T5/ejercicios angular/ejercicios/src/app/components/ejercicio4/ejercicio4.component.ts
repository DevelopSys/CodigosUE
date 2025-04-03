import { Component } from '@angular/core';
import { producto } from '../../model/producto';

@Component({
  selector: 'app-ejercicio4',
  standalone: false,
  templateUrl: './ejercicio4.component.html',
  styleUrl: './ejercicio4.component.css',
})
export class Ejercicio4Component {
  productos: producto[] = [
    { nombre: 'Producto 1', precio: 10, cantidad: 2, categoria: 'Categoria 1' },
    { nombre: 'Producto 2', precio: 20, cantidad: 1, categoria: 'Categoria 2' },
    { nombre: 'Producto 3', precio: 15, cantidad: 3, categoria: 'Categoria 1' },
    { nombre: 'Producto 4', precio: 30, cantidad: 1, categoria: 'Categoria 3' },
  ];

  totalPrecio(): number {
    return this.productos.reduce(
      (total, producto) => total + producto.precio * producto.cantidad,
      0
    );
  }

  eliminarElemento(_t4: producto) {
    this.productos = this.productos.filter((producto) => producto !== _t4);
  }
}
