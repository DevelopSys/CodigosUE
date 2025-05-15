import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Libro } from '../model/objetos';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  getAllLibros(): Observable<any> {
    return this.http.get('https://stephen-king-api.onrender.com/api/books');
  }
}
