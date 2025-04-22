import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<any> {
    let url = 'https://dummyjson.com/users';
    return this.http.get(url);
  }
}
