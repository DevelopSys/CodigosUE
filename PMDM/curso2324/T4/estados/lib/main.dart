import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: FormularioUsuarios(),
    );
  }
}

class FormularioUsuarios extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Formulario usuarios")),
        body: FormularioEstado());
  }
}

class FormularioEstado extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _StateFormulario();
  }
}

class _StateFormulario extends State<FormularioEstado> {
  final TextEditingController _controllerNombre = TextEditingController();
  final TextEditingController _controllerPass = TextEditingController();

  List listado = [];
  String nombre = "";
  String pass = "";
  var estadoCheck = false;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(20.0),
      child: Center(
          child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
        const Text("Formulario de login"),
        const Padding(padding: EdgeInsets.only(top: 10.0, bottom: 10.0)),
        TextField(
          controller: _controllerNombre,
          decoration: const InputDecoration(
              border: OutlineInputBorder(), labelText: "Introduce nombre"),
        ),
        const Padding(padding: EdgeInsets.only(top: 10.0, bottom: 10.0)),
        TextField(
          controller: _controllerPass,
          decoration: const InputDecoration(
              border: OutlineInputBorder(), labelText: "Introduce pass"),
        ),
        const Padding(padding: EdgeInsets.only(top: 10.0, bottom: 10.0)),
        // onCheckedChangeListener(onChange( view, boolean  ))
        /*
        * <Checkbox android:text = "Recordar contraseña">
        * */
        Row(
          children: [
            Checkbox(
                value: estadoCheck,
                onChanged: (bool? value) {
                  setState(() {
                    estadoCheck = value!;
                    /*if (!estadoCheck){
              this.nombre = "";
              this.pass = "";
            }*/
                  });
                }),
            Text("Recuperar estado"),
          ],
        ),
        ElevatedButton(
            onPressed: () {
              // cuando pulse el boton -> nombre = controller
              // print(_controllerNombre.value.text);
              // print(_controllerPass.value.text);

              setState(() {

                if (estadoCheck) {
                  nombre = _controllerNombre.value.text;
                  pass = _controllerPass.value.text;
                }
              });
            },
            child: const Text("Pulsar")),
        const Padding(padding: EdgeInsets.only(top: 10.0, bottom: 10.0)),
        Text("El nombre introducido es: $nombre"),
        const Padding(padding: EdgeInsets.only(top: 10.0, bottom: 10.0)),
        Text("La contraseña introducida es: $pass"),
      ])),
    );
  }
}
