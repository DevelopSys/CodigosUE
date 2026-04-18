export class CursoDTO {

  constructor(data:Partial<CursoDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  idProfesor?: number|null;

}
