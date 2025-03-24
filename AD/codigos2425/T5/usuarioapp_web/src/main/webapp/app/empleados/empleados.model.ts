export class EmpleadosDTO {

  constructor(data:Partial<EmpleadosDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  sueldo?: number|null;
  idPerfil?: number|null;

}
