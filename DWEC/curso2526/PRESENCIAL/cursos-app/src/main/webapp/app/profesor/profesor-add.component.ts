import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { ProfesorService } from 'app/profesor/profesor.service';
import { ProfesorDTO } from 'app/profesor/profesor.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-profesor-add',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './profesor-add.component.html'
})
export class ProfesorAddComponent implements OnInit {

  profesorService = inject(ProfesorService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  idCursoFKValues?: Map<number,string>;

  addForm = new FormGroup({
    nombre: new FormControl(null, [Validators.required, Validators.maxLength(255)]),
    correo: new FormControl(null, [Validators.required, Validators.maxLength(255)]),
    idCursoFK: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@profesor.create.success:Profesor was created successfully.`,
      PROFESOR_CORREO_UNIQUE: $localize`:@@Exists.profesor.correo:This Correo is already taken.`,
      PROFESOR_ID_CURSO_FKUNIQUE: $localize`:@@Exists.profesor.idCursoFK:This Curso is already referenced by another Profesor.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.profesorService.getIdCursoFKValues()
        .subscribe({
          next: (data) => this.idCursoFKValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new ProfesorDTO(this.addForm.value);
    this.profesorService.createProfesor(data)
        .subscribe({
          next: () => this.router.navigate(['/profesors'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
