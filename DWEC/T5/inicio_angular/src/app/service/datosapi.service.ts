import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root',
})
export class DatosapiService {
  constructor(private http: HttpClient) {}
  getAllProducts(): Observable<any> {
    return this.http.get('https://dummyjson.com/products');
  }

  getAllCategories(): Observable<any> {
    return this.http.get('https://dummyjson.com/products/categories');
  }

  getAllProductsCategory(categoria: string): Observable<any> {
    return this.http.get(
      `https://dummyjson.com/products/category/${categoria}`
    );
  }
}
