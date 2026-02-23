import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { ProductosService } from 'app/productos/productos.service';
import { ProductosDTO } from 'app/productos/productos.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-productos-add',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './productos-add.component.html'
})
export class ProductosAddComponent {

  productosService = inject(ProductosService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  addForm = new FormGroup({
    nombre: new FormControl(null, [Validators.maxLength(255)]),
    precio: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@productos.create.success:Productos was created successfully.`
    };
    return messages[key];
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new ProductosDTO(this.addForm.value);
    this.productosService.createProductos(data)
        .subscribe({
          next: () => this.router.navigate(['/productoss'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
