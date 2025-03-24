import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { EmpleadosService } from 'app/empleados/empleados.service';
import { EmpleadosDTO } from 'app/empleados/empleados.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { updateForm } from 'app/common/utils';


@Component({
  selector: 'app-empleados-edit',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './empleados-edit.component.html'
})
export class EmpleadosEditComponent implements OnInit {

  empleadosService = inject(EmpleadosService);
  route = inject(ActivatedRoute);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  idPerfilValues?: Map<number,string>;
  currentId?: number;

  editForm = new FormGroup({
    id: new FormControl({ value: null, disabled: true }),
    nombre: new FormControl(null, [Validators.maxLength(255)]),
    sueldo: new FormControl(null),
    idPerfil: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      updated: $localize`:@@empleados.update.success:Empleados was updated successfully.`,
      EMPLEADOS_ID_PERFIL_UNIQUE: $localize`:@@Exists.empleados.idPerfil:This Perfiles is already referenced by another Empleados.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.currentId = +this.route.snapshot.params['id'];
    this.empleadosService.getIdPerfilValues()
        .subscribe({
          next: (data) => this.idPerfilValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    this.empleadosService.getEmpleados(this.currentId!)
        .subscribe({
          next: (data) => updateForm(this.editForm, data),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.editForm.markAllAsTouched();
    if (!this.editForm.valid) {
      return;
    }
    const data = new EmpleadosDTO(this.editForm.value);
    this.empleadosService.updateEmpleados(this.currentId!, data)
        .subscribe({
          next: () => this.router.navigate(['/empleadoss'], {
            state: {
              msgSuccess: this.getMessage('updated')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.editForm, this.getMessage)
        });
  }

}
