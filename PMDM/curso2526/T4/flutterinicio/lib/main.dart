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
      ),
      home: CalculadoraPage(),
    );
  }
}

class CalculadoraPage extends StatefulWidget {
  const CalculadoraPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraPage> {
  var resultado = 0;
  var controllerOp1 = new TextEditingController();
  var controllerOp2 = new TextEditingController();

  void calcular() {
    try {
      var op1 = int.tryParse(controllerOp1.text);
      var op2 = int.tryParse(controllerOp2.text);
      setState(() {
        resultado = op1! + op2!;
      });
    } catch (exception) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: const Text('Dato incorrecto'),
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Aplicacion de calculadora")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text("Aplicacion para la suma de elementos"),
            Padding(padding: EdgeInsets.all(24)),
            const Text(
              "Vamos a poner dos edit text para poder sumar elementos",
            ),
            const Padding(padding: EdgeInsets.all(24)),
            Padding(
              padding: const EdgeInsets.only(left: 24, right: 24),
              child: Row(
                children: [
                  Expanded(
                    child: TextField(
                      controller: controllerOp1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Introduce el primer valor',
                      ),
                    ),
                  ),
                  Padding(padding: EdgeInsets.all(12)),
                  Expanded(
                    child: TextField(
                      controller: controllerOp2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Introduce el segundo valor',
                      ),
                    ),
                  ),
                ],
              ),
            ),
            const Padding(padding: EdgeInsets.all(24)),
            ElevatedButton(
              onPressed: () {
                calcular();
              },
              child: const Text('Calcular'),
            ),
            const Padding(padding: EdgeInsets.all(24)),
            Text("El resultado es $resultado"),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print("Pulsado el FAB");
        },
        child: const Text("Pulsar"),
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,

        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Pulsa el boton para poder incrementar el contador de pulsaciones:',
            ),
            Padding(padding: EdgeInsets.only(top: 24, bottom: 24)),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
            Padding(padding: EdgeInsets.only(top: 48)),
            const Text('Este es otro hijo de la columna'),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}
