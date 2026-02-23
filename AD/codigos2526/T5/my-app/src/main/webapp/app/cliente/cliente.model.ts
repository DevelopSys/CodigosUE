export class ClienteDTO {

  constructor(data:Partial<ClienteDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  correo?: string|null;
  telefono?: string|null;
  productos?: number[]|null;

}
