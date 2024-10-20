export class UsuarioClase {
  constructor(
    private nombre: string,
    private apellido: string,
    private telefono: Number,
    private pass: string
  ) {}
}

export interface UsurioIntefaz {
  nombre: string;
  apellido: string;
  telefono: Number;
  pass: string;
  /* alquileres: []; */
}
