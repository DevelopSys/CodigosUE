import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { ClienteService } from 'app/cliente/cliente.service';
import { ClienteDTO } from 'app/cliente/cliente.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-cliente-add',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './cliente-add.component.html'
})
export class ClienteAddComponent implements OnInit {

  clienteService = inject(ClienteService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  productosValues?: Map<number,string>;

  addForm = new FormGroup({
    nombre: new FormControl(null, [Validators.maxLength(255)]),
    correo: new FormControl(null, [Validators.maxLength(255)]),
    telefono: new FormControl(null, [Validators.maxLength(255)]),
    productos: new FormControl([])
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@cliente.create.success:Cliente was created successfully.`,
      CLIENTE_CORREO_UNIQUE: $localize`:@@Exists.cliente.correo:This Correo is already taken.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.clienteService.getProductosValues()
        .subscribe({
          next: (data) => this.productosValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new ClienteDTO(this.addForm.value);
    this.clienteService.createCliente(data)
        .subscribe({
          next: () => this.router.navigate(['/clientes'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
