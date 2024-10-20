import { Component } from '@angular/core';
import { DatosapiService } from '../../service/datosapi.service';
import { Producto } from '../../model/producto';

@Component({
  selector: 'app-productosapi',
  templateUrl: './productosapi.component.html',
  styleUrl: './productosapi.component.css',
})
export class ProductosapiComponent {
  productos: Producto[] = [];
  categorias: string[] = [];
  categoriaSeleccionada = '';

  constructor(private servicio: DatosapiService) {
    this.servicio.getAllProducts().subscribe((item) => {
      this.productos = item.products;
    });

    this.servicio.getAllCategories().subscribe((item) => {
      this.categorias = item;
    });
  }

  cambioSeleccion() {
    this.servicio
      .getAllProductsCategory(this.categoriaSeleccionada)
      .subscribe((item) => {
        this.productos = item.products;
      });
  }

  mostrarDatos() {
    this.servicio.getAllProducts().subscribe((item) => {
      this.productos = item.products;
    });
  }
}
