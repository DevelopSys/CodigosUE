import 'package:flutter/material.dart';
import 'package:proyectolistas/Usuario.dart';

class PantallaListado extends StatelessWidget {
  const PantallaListado({super.key});

  @override
  Widget build(BuildContext context) {
    final List<Usuario> listaUsuarios = [
      Usuario("Borja1", "Marin1", "correo@gmail1"),
      Usuario("Borja2", "Marin2", "correo@gmail2"),
      Usuario("Borja3", "Marin3", "correo@gmail3"),
      Usuario("Borja4", "Marin4", "correo@gmail4"),
      Usuario("Borja5", "Marin5", "correo@gmail5"),
      Usuario("Borja6", "Marin6", "correo@gmail6"),
      Usuario("Borja7", "Marin6", "correo@gmail6"),
      Usuario("Borja8", "Marin6", "correo@gmail6"),
      Usuario("Borja9", "Marin6", "correo@gmail6")
    ];
    return Scaffold(
      appBar: AppBar(title: const Text("Pantalla listado")),
      body: ListView.builder(
          itemCount: listaUsuarios.length,
          itemBuilder: (context, index) {
            return ListTile(
                leading: const Icon(Icons.access_alarms),
                subtitle: Text(listaUsuarios[index].apellido),
                title: Text(listaUsuarios[index].nombre),
                onTap: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      action: SnackBarAction(
                        label: 'Action',
                        onPressed: () {
                          // Code to execute.
                        },
                      ),
                      content: Text(listaUsuarios[index].correo),
                    ),
                  );
                });
          }),
    );
  }
}
