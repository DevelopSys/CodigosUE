import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistroComponent } from './components/registro/registro.component';
import { AlquilerComponent } from './components/alquiler/alquiler.component';
import { CatalogoComponent } from './components/catalogo/catalogo.component';
import { DetalleComponent } from './components/detalle/detalle.component';

const routes: Routes = [
  { path: 'registrar', component: RegistroComponent },
  { path: 'alquilar', component: AlquilerComponent },
  { path: 'catalogo', component: CatalogoComponent },
  { path: 'detalle', component: DetalleComponent },
  { path: '**', redirectTo: 'alquilar' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
