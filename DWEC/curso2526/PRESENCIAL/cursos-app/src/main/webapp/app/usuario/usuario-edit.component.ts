import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { UsuarioService } from 'app/usuario/usuario.service';
import { UsuarioDTO } from 'app/usuario/usuario.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { updateForm } from 'app/common/utils';


@Component({
  selector: 'app-usuario-edit',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './usuario-edit.component.html'
})
export class UsuarioEditComponent implements OnInit {

  usuarioService = inject(UsuarioService);
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
      updated: $localize`:@@usuario.update.success:Usuario was updated successfully.`,
      USUARIO_CORREO_UNIQUE: $localize`:@@Exists.usuario.correo:This Correo is already taken.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.currentId = +this.route.snapshot.params['id'];
    this.usuarioService.getIdCursoFKValues()
        .subscribe({
          next: (data) => this.idCursoFKValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    this.usuarioService.getUsuario(this.currentId!)
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
    const data = new UsuarioDTO(this.editForm.value);
    this.usuarioService.updateUsuario(this.currentId!, data)
        .subscribe({
          next: () => this.router.navigate(['/usuarios'], {
            state: {
              msgSuccess: this.getMessage('updated')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.editForm, this.getMessage)
        });
  }

}
