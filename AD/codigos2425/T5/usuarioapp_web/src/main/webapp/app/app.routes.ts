import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmpleadosListComponent } from './empleados/empleados-list.component';
import { EmpleadosAddComponent } from './empleados/empleados-add.component';
import { EmpleadosEditComponent } from './empleados/empleados-edit.component';
import { UsuariosListComponent } from './usuarios/usuarios-list.component';
import { UsuariosAddComponent } from './usuarios/usuarios-add.component';
import { UsuariosEditComponent } from './usuarios/usuarios-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'empleadoss',
    component: EmpleadosListComponent,
    title: $localize`:@@empleados.list.headline:Empleadoses`
  },
  {
    path: 'empleadoss/add',
    component: EmpleadosAddComponent,
    title: $localize`:@@empleados.add.headline:Add Empleados`
  },
  {
    path: 'empleadoss/edit/:id',
    component: EmpleadosEditComponent,
    title: $localize`:@@empleados.edit.headline:Edit Empleados`
  },
  {
    path: 'usuarioss',
    component: UsuariosListComponent,
    title: $localize`:@@usuarios.list.headline:Usuarioses`
  },
  {
    path: 'usuarioss/add',
    component: UsuariosAddComponent,
    title: $localize`:@@usuarios.add.headline:Add Usuarios`
  },
  {
    path: 'usuarioss/edit/:id',
    component: UsuariosEditComponent,
    title: $localize`:@@usuarios.edit.headline:Edit Usuarios`
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
