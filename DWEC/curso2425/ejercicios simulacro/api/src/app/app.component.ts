import { Component } from '@angular/core';
import { Libro } from './model/objetos';
import { Data } from '@angular/router';
import { DataService } from './services/data.service';
import { log } from 'console';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  listaLibros?: any[];
  title = 'api';

  constructor(private servicio: DataService) {
    this.servicio.getAllLibros().subscribe((response) => {
      this.listaLibros = response.data;
      console.log(this.listaLibros);
    });
  }
}
