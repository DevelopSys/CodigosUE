import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ProductosComponent } from './components/productos/productos.component';
import { ProductosapiComponent } from './components/productosapi/productosapi.component';

const routes: Routes = [
  /* todas las rutas que tiene mi app */
  {
    path: 'home',
    component: InformacionComponent,
  },
  {
    path: 'formulario',
    component: FormularioComponent,
  },
  {
    path: 'productos/:categoria',
    component: ProductosComponent,
  },
  {
    path: 'productos',
    component: ProductosComponent,
  },
  {
    path: 'productosapi',
    component: ProductosapiComponent,
  },
  {
    path: '**',
    redirectTo: 'home',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
