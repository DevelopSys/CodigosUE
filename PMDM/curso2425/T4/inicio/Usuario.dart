class Usuario{
  String correo;
  String pass;
  String? direccion;

  // constructor principal
  Usuario(this.correo, this.pass, this.direccion);
  // constructor nominal
  Usuario.conCorreo(this.correo, this.pass, this.direccion);

  mostrarDatos(){
    print("Correo: $correo");
    print("Pass: $pass");
    print("Direccion: $direccion");
  }
}