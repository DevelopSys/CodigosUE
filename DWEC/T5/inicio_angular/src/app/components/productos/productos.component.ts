import { Component } from '@angular/core';
import { Producto } from '../../model/producto';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { DatosService } from '../../service/datos.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css',
})
export class ProductosComponent {
  /* caapturar el dato que me han pasado por URL */

  productos: Producto[] = [];
  constructor(
    private rutaActiva: ActivatedRoute,
    private servicio: DatosService
  ) {
    // acceso al servicion
    //this.productos = this.servicio.getAllProducts();

    //console.log(this.rutaActiva.snapshot.paramMap.get('categoria'));
    this.rutaActiva.paramMap.subscribe((element: ParamMap) => {
      //console.log(element.get('categoria'));
      this.productos = this.servicio.getAllProductosCategory(
        element.get('categoria')!!.toString()
      );
    });
  }
}
