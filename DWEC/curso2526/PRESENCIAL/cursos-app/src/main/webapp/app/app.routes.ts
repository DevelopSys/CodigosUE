import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UsuarioListComponent } from './usuario/usuario-list.component';
import { UsuarioAddComponent } from './usuario/usuario-add.component';
import { UsuarioEditComponent } from './usuario/usuario-edit.component';
import { CursoListComponent } from './curso/curso-list.component';
import { CursoAddComponent } from './curso/curso-add.component';
import { CursoEditComponent } from './curso/curso-edit.component';
import { ProfesorListComponent } from './profesor/profesor-list.component';
import { ProfesorAddComponent } from './profesor/profesor-add.component';
import { ProfesorEditComponent } from './profesor/profesor-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'usuarios',
    component: UsuarioListComponent,
    title: $localize`:@@usuario.list.headline:Usuarios`
  },
  {
    path: 'usuarios/add',
    component: UsuarioAddComponent,
    title: $localize`:@@usuario.add.headline:Add Usuario`
  },
  {
    path: 'usuarios/edit/:id',
    component: UsuarioEditComponent,
    title: $localize`:@@usuario.edit.headline:Edit Usuario`
  },
  {
    path: 'cursos',
    component: CursoListComponent,
    title: $localize`:@@curso.list.headline:Cursoes`
  },
  {
    path: 'cursos/add',
    component: CursoAddComponent,
    title: $localize`:@@curso.add.headline:Add Curso`
  },
  {
    path: 'cursos/edit/:id',
    component: CursoEditComponent,
    title: $localize`:@@curso.edit.headline:Edit Curso`
  },
  {
    path: 'profesors',
    component: ProfesorListComponent,
    title: $localize`:@@profesor.list.headline:Profesors`
  },
  {
    path: 'profesors/add',
    component: ProfesorAddComponent,
    title: $localize`:@@profesor.add.headline:Add Profesor`
  },
  {
    path: 'profesors/edit/:id',
    component: ProfesorEditComponent,
    title: $localize`:@@profesor.edit.headline:Edit Profesor`
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
