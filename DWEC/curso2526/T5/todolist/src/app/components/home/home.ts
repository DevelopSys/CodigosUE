import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule, CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  correo?: string | undefined;
  pass?: string | undefined;
  validacion?: boolean | undefined = undefined;

  validarUsuario() {
    if (this.correo == 'borja@gmail.com' && this.pass == 'ue1234a') {
      this.validacion = true;
    } else {
      this.validacion = false;
    }
  }
}
