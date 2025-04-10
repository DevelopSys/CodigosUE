import 'package:flutter/material.dart';

class MyLoginPage extends StatelessWidget {
  const MyLoginPage({super.key});

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: [
            Text("Ejemplo app"),
            Padding(padding: EdgeInsets.only(left: 10.0)),
            Text("Login"),
          ],
        ),
      ),
      body: Container(
        padding: EdgeInsets.all(50.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("Por favor introduce tus datos para hacer login"),
              Padding(padding: EdgeInsets.only(bottom: 40)),
              TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Introduce correo',
                ),
              ),
              Padding(padding: EdgeInsets.only(bottom: 20)),
              TextField(
                obscureText: true,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Introduce pass',
                ),
              ),
              Padding(padding: EdgeInsets.only(bottom: 40)),
              ElevatedButton(onPressed: () {
                print("Login ejecutado");
              }, child: Text("Login")),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print("Ejecutada la accion principal del sistema");
        },
        child: Icon(Icons.access_alarm_sharp),
      ),
    );
  }
}
