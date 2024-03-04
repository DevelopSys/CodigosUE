import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { FormsModule } from '@angular/forms';
import { SeleccionComponent } from './components/seleccion/seleccion.component';
import { InformacionComponent } from './components/informacion/informacion.component';
import { ProductosComponent } from './components/productos/productos.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';

@NgModule({
  declarations: [AppComponent, FormularioComponent, SeleccionComponent, InformacionComponent, ProductosComponent, ImagenesPipe],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
