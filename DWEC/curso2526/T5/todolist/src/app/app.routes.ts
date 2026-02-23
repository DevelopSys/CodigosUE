import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Add } from './components/add/add';
import { Search } from './components/search/search';
import { List } from './components/list/list';

export const routes: Routes = [
  { path: 'add', component: Add },
  { path: 'home', component: Home },
  { path: 'list', component: List },
  { path: 'search', component: Search },
  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];
