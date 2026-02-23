import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ClienteListComponent } from './cliente/cliente-list.component';
import { ClienteAddComponent } from './cliente/cliente-add.component';
import { ClienteEditComponent } from './cliente/cliente-edit.component';
import { ProductosListComponent } from './productos/productos-list.component';
import { ProductosAddComponent } from './productos/productos-add.component';
import { ProductosEditComponent } from './productos/productos-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'clientes',
    component: ClienteListComponent,
    title: $localize`:@@cliente.list.headline:Clientes`
  },
  {
    path: 'clientes/add',
    component: ClienteAddComponent,
    title: $localize`:@@cliente.add.headline:Add Cliente`
  },
  {
    path: 'clientes/edit/:id',
    component: ClienteEditComponent,
    title: $localize`:@@cliente.edit.headline:Edit Cliente`
  },
  {
    path: 'productoss',
    component: ProductosListComponent,
    title: $localize`:@@productos.list.headline:Productoses`
  },
  {
    path: 'productoss/add',
    component: ProductosAddComponent,
    title: $localize`:@@productos.add.headline:Add Productos`
  },
  {
    path: 'productoss/edit/:id',
    component: ProductosEditComponent,
    title: $localize`:@@productos.edit.headline:Edit Productos`
  },
  {
    path: 'error',
    component: ErrorComponent,
    title: $localize`:@@error.page.headline:Error`
  },
  {
    path: '**',
    component: ErrorComponent,
    title: $localize`:@@notFound.headline:Page not found`
  }
];
