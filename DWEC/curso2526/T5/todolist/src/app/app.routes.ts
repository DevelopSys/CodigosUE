import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Add } from './components/add/add';
import { Search } from './components/search/search';
import { List } from './components/list/list';
import { Prioridades } from './components/prioridades/prioridades';
import { Detail } from './components/detail/detail';
import { PostFetch } from './components/post-fetch/post-fetch';

export const routes: Routes = [
  { path: 'add', component: Add },
  { path: 'home', component: Home },
  { path: 'list', component: List },
  { path: 'search', component: Search },
  { path: 'fetch', component: PostFetch },
  { path: 'detail/:id', component: Detail },
  { path: 'priority/:id', component: Prioridades },
  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];
