import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  lista: string[] = [];
  nombre?: string;

  agregarTarea() {
    /* comprobacion de que lo que esta en el input no es undefined */
    this.lista.push(this.nombre!!);
  }
}
