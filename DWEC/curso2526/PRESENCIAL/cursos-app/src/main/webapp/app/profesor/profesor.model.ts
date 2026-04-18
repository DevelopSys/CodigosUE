export class ProfesorDTO {

  constructor(data:Partial<ProfesorDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  correo?: string|null;
  idCursoFK?: number|null;

}
