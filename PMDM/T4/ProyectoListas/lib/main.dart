import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:proyectolistas/PantallaListado.dart';
import 'package:proyectolistas/PantallaRegistro.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: PantallaPrincipal(),
      routes: {
        "lista": (context) => PantallaListado(),
        "registro": (context) => PantallaRegistro()
      },
    );
  }
}

class PantallaPrincipal extends StatelessWidget {
  const PantallaPrincipal({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Ejemplo de app navegacion")),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                ElevatedButton(
                    onPressed: () {
                      Navigator.pushNamed(context, "lista");
                    },
                    child: Text("Listado")),
                Padding(padding: EdgeInsets.fromLTRB(5.0, 0, 5.0, 0)),
                ElevatedButton(onPressed: () {
                  Navigator.pushNamed(context, "registro");
                }, child: const Text("Formulario"))
              ],
            ),
          ],
        ));
  }
}
