import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLinkWithHref, Router } from '@angular/router';
import { Home } from './components/home/home';
import { List } from './components/list/list';
import { Search } from './components/search/search';
import { Add } from './components/add/add';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, RouterLinkWithHref],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  constructor(private gestorRutas: Router) {}

  navegar(param: string) {
    this.gestorRutas.navigate(['priority', param]);
  }
}
