import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { ProductosDTO } from 'app/productos/productos.model';


@Injectable({
  providedIn: 'root',
})
export class ProductosService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/productoss';

  getAllProductoses() {
    return this.http.get<ProductosDTO[]>(this.resourcePath);
  }

  getProductos(id: number) {
    return this.http.get<ProductosDTO>(this.resourcePath + '/' + id);
  }

  createProductos(productosDTO: ProductosDTO) {
    return this.http.post<number>(this.resourcePath, productosDTO);
  }

  updateProductos(id: number, productosDTO: ProductosDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, productosDTO);
  }

  deleteProductos(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

}
