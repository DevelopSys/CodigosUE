import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { ProfesorService } from 'app/profesor/profesor.service';
import { ProfesorDTO } from 'app/profesor/profesor.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { updateForm } from 'app/common/utils';


@Component({
  selector: 'app-profesor-edit',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './profesor-edit.component.html'
})
export class ProfesorEditComponent implements OnInit {

  profesorService = inject(ProfesorService);
  route = inject(ActivatedRoute);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  idCursoFKValues?: Map<number,string>;
  currentId?: number;

  editForm = new FormGroup({
    id: new FormControl({ value: null, disabled: true }),
    nombre: new FormControl(null, [Validators.required, Validators.maxLength(255)]),
    correo: new FormControl(null, [Validators.required, Validators.maxLength(255)]),
    idCursoFK: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      updated: $localize`:@@profesor.update.success:Profesor was updated successfully.`,
      PROFESOR_CORREO_UNIQUE: $localize`:@@Exists.profesor.correo:This Correo is already taken.`,
      PROFESOR_ID_CURSO_FKUNIQUE: $localize`:@@Exists.profesor.idCursoFK:This Curso is already referenced by another Profesor.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.currentId = +this.route.snapshot.params['id'];
    this.profesorService.getIdCursoFKValues()
        .subscribe({
          next: (data) => this.idCursoFKValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    this.profesorService.getProfesor(this.currentId!)
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
    const data = new ProfesorDTO(this.editForm.value);
    this.profesorService.updateProfesor(this.currentId!, data)
        .subscribe({
          next: () => this.router.navigate(['/profesors'], {
            state: {
              msgSuccess: this.getMessage('updated')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.editForm, this.getMessage)
        });
  }

}
