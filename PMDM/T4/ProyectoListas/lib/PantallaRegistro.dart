import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:proyectolistas/Usuario.dart';

class PantallaRegistro extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return RegistroEstado();
  }
}

class RegistroEstado extends State<PantallaRegistro> {
  final List<Usuario> listaUsuarios = [];

  final controladorNombre = TextEditingController();
  final controladorApellido = TextEditingController();
  final controladorCorreo = TextEditingController();
  final controladorTelefono = TextEditingController();

  agregarUsuario(Usuario usuario) {
    setState(() {
      listaUsuarios.add(usuario);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Pantalla registro"),
        ),
        body: Form(
          child: Padding(
            padding: EdgeInsets.all(42.0),
            child: Column(
              children: [
                TextFormField(
                    controller: controladorNombre,
                    decoration: InputDecoration(hintText: "nombre usuario")),
                TextFormField(
                    controller: controladorApellido,
                    decoration: InputDecoration(hintText: "apellido usuario")),
                TextFormField(
                    controller: controladorCorreo,
                    decoration: InputDecoration(hintText: "correo usuario")),
                TextFormField(
                    controller: controladorTelefono,
                    decoration: InputDecoration(hintText: "telefono usuario"),
                    obscureText: true),
                Padding(padding: EdgeInsets.fromLTRB(0, 50.0, 0, 0)),
                ElevatedButton(
                    onPressed: () {
                      /*listaUsuarios.add(Usuario(controladorNombre.text,
                          controladorApellido.text, controladorCorreo.text));*/
                      agregarUsuario(Usuario(controladorNombre.text,
                          controladorApellido.text, controladorCorreo.text));
                    },
                    child: Text("Agregar usuario")),
                Text("El numero de usuarios es de ${listaUsuarios.length}")
              ],
            ),
          ),
        ));
  }
}
