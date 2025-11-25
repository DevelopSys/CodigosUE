class Usuario {
  nombre;
  apellido;
  correo;
  fecha;

  //public Usuario(){}
  constructor(nombre, apellido, correo, fecha) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.fecha = fecha;
  }

  // public String getNombre() {return nombre}
  // getter
  getNombre() {
    return this.nombre;
  }
  // setter
  setNombre(nombre) {
    this.nombre = nombre;
  }

  getCorreo() {
    return this.correo;
  }

  setCorreo(correo) {
    this.correo = correo;
  }

  mostrarDatos() {
    return `${this.nombre} ${this.apellido}`;
  }

  getDominio() {
    return this.correo.substring(this.correo.indexOf("@"));
  }
}
