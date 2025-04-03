import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Ejercicio1Component } from './components/ejercicio1/ejercicio1.component';
import { Ejercicio2Component } from './components/ejercicio2/ejercicio2.component';
import { Ejercicio4Component } from './components/ejercicio4/ejercicio4.component';

const routes: Routes = [
  { path: '', redirectTo: 'ejercicio1', pathMatch: 'full' },
  { path: 'ejercicio1', component: Ejercicio1Component },
  { path: 'ejercicio2', component: Ejercicio2Component },
  { path: 'ejercicio4', component: Ejercicio4Component },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
