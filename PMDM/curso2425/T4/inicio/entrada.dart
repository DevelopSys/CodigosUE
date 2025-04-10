// tipo_de_retorno nombreMetodo(){}
import 'Usuario.dart';

void main() {
  // tipadas
  String nombre = "Borja";
  String apellido = "Martin";
  String? direccion;
  int edad = 40;
  late String correo;
  correo = "borja@gmail";

  // dinamica
  var telefono;
  telefono = 123;

  // saludar(nombre, apellido, "Alcorcon", 123123);
  /*saludarNominal(
    apellidoP: apellido,
    direccionP: "Alcorcon",
    telefonoP: telefono,
    nombreP: nombre,
  );*/

  Usuario usuario = new Usuario(correo, "123", direccion);
  usuario.mostrarDatos();
}

saludar(String nombre, String apellido, String direccion,
    [int telefono = 00000]) {
  print("Nombre $nombre Apelldio: $apellido "
      "Direccion: ${direccion} Telefono: $telefono");
}

saludarNominal(
    {required String nombreP,
    required String apellidoP,
    required String direccionP,
    int telefonoP = 0}) {
  print("Nombre $nombreP Apelldio: $apellidoP "
      "Direccion: ${direccionP} Telefono: $telefonoP");
}
