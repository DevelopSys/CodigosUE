class Usuario{

  String nombre;
  String apellido;
  int edad;
  // String? direccion

  // constructor principal y UNICO
  Usuario(this.nombre, this.apellido, this.edad);
  // constructores nominales
  // Usuario.conDireccion(this.nombre, this.apellido, this.edad, this.direccion)
  mostrarDatos(){
    print("Nombre $nombre");
    print("Apellido $apellido");
    print("Edad $edad");
  }
}