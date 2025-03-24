export class UsuariosDTO {

  constructor(data:Partial<UsuariosDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  correo?: string|null;
  pass?: string|null;

}
