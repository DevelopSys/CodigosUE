export class UsuarioDTO {

  constructor(data:Partial<UsuarioDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  correo?: string|null;
  idCursoFK?: number|null;

}
