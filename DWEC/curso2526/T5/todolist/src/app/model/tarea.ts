/* 
clase -> construct attr metodos
*/
export class tareaClase {
  constructor(
    private nombre: string,
    private responsable: string,
    private definicion: string,
    private fecha: string,
    private prioridad: string,
    private complemento: string,
  ) {}

  get getNombre() {
    return this.nombre;
  }

  set setNombre(nombre: string) {
    this.nombre = nombre;
  }

  // define los metodos que quieras
}

export interface tarea {
  id: number;
  nombre: string;
  responsable: string;
  fecha: string;
  descripcion: string;
  prioridad: number;
  complemento: string;
}
