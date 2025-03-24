import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { EmpleadosService } from 'app/empleados/empleados.service';
import { EmpleadosDTO } from 'app/empleados/empleados.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-empleados-add',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './empleados-add.component.html'
})
export class EmpleadosAddComponent implements OnInit {

  empleadosService = inject(EmpleadosService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  idPerfilValues?: Map<number,string>;

  addForm = new FormGroup({
    nombre: new FormControl(null, [Validators.maxLength(255)]),
    sueldo: new FormControl(null),
    idPerfil: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@empleados.create.success:Empleados was created successfully.`,
      EMPLEADOS_ID_PERFIL_UNIQUE: $localize`:@@Exists.empleados.idPerfil:This Perfiles is already referenced by another Empleados.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.empleadosService.getIdPerfilValues()
        .subscribe({
          next: (data) => this.idPerfilValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new EmpleadosDTO(this.addForm.value);
    this.empleadosService.createEmpleados(data)
        .subscribe({
          next: () => this.router.navigate(['/empleadoss'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
