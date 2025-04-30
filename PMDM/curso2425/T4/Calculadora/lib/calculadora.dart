import 'package:flutter/material.dart';

class Calculadora extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<Calculadora> {
  int resultado = 10;
  TextEditingController controller1 = TextEditingController();
  TextEditingController controller2 = TextEditingController();
  List<String> elementos = ["Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"];

  Widget crearFila(int posicion){
    return ListTile(title: Text("${elementos[posicion]}"),);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Caculadora app", style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.lightBlueAccent,),
      body: Container(
        padding: EdgeInsets.all(24),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text("Introduce datos para realizar calculo"),
              Padding(padding: EdgeInsets.only(bottom: 12)),
              Row(
                children: [
                  Expanded(
                    child: TextField(
                      controller: controller1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Input 1',
                      ),
                    ),
                  ),
                  Padding(padding: EdgeInsets.all(24)),
                  Expanded(
                    child: TextField(
                      controller: controller2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Input 2',
                      ),
                    ),
                  ),
                ],
              ),
              Padding(padding: EdgeInsets.only(bottom: 12)),
              Text("El resultado es: $resultado"),
              Padding(padding: EdgeInsets.only(bottom: 12)),
              ElevatedButton(onPressed: () {
                // ejecutado al pulsar un boton
                int op1 = int.parse(controller1.text);
                int op2 = int.parse(controller2.text);
                setState(() {
                  resultado = op1 + op2;
                  elementos.add("El resultado obtenido de la suma entre $op1 y $op2 es $resultado");
                  controller1.clear();
                  controller2.clear();
                });
              }, child: Text("Calcular")),
              // el itemBuilder indica como se pintan las filas
              Expanded(child: ListView.builder(
                  itemCount: elementos.length, itemBuilder:(context, index)=> crearFila(index)))
            ],
          ),
        ),
      ),
    );
  }
}
