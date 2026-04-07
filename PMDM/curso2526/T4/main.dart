import 'usuario.dart';

void main() {
  // var val
  // si no pongo nada -> variable mutable pero tipada
  String nombre = "Borja";
  String apellido = "Martin";
  late String correo;
  correo = "borja@ue.com";
  String? direccion;

  print("Mi nombre es ${nombre} y mi apellido es ${apellido} "
      ". Mi correo es ${correo} ");

  print("La direccion del usuario es ${direccion ?? "no especificada"}");

  // dynamic -> no me indicas el tipo de la variable y este puede ser cambiante
  var profesion;
  profesion = "Profesor";
  print("La profesion tiene un valor de ${profesion}");
  profesion = true;
  print("La profesion tiene un valor de ${profesion}");
  profesion = 100;
  print("La profesion tiene un valor de ${profesion}");

  // saludar(nombre="Borja")
  // saludar(nombre, apellido, 11111);
  // saludar(nombre="Borja");
  saludarNominal(nombre: "Borja", apellido: "Martin");
  saludar(nombre);
  Usuario usuario = new Usuario(nombre, apellido, 123);
  usuario.mostrarDatos();
}

// posicionales
// al no indicar tipo de retorno, si hay return es dynamic (var)
saludar(String nombre,
    [String apellido = "sin apellido", int telefono = 0]) {
  print("Bienvenido $nombre $apellido $telefono esta será tu primera app dart");
  return bool;
}

String saludarNominal(
    {required String nombre, required String apellido, int telefono = 0}) {
  print(
      "Bienvenido $nombre $apellido $telefono esta será tu primera app dart con funcion nominal");
  return "Hola";
}

// parametros posicionales y nominales
