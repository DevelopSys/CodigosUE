console.log("Ejemplo de codigo js");
// cometario
/*
multiple
*/
// dinamicas let - var
// tipo nombre = valor

// ambito de bloque
// navegador
let nombre = "Borja";
let edad = 23; // number
let altura = 1.74; // number
let acierto = true;
let letras = "A";
let array = []; // dinamicos
let objeto = new Date();
let objetoMio = { dato1: 4, dato2: [{ prop1: "1", prop2: "2" }] };
let elemento; // undefined
let nulo = null;

// calculo ¿son numeros?
if (isNaN(nombre)) {
  console.log("El dato no es un numero");
}

alert("Esto es un ejemplo de cuadro de aviso");
let continuar = confirm("Esta seguro que quieres continuar");
if (continuar) {
  let numero1 = prompt("introduce el numero uno");
  let numero2 = prompt("introduce el numero dos");
  /*console.log(
    `La suma de los dos numeros es ${Number(numero1) + Number(numero2)}`
  );*/
  console.log(
    `La suma de ${numero1} y ${numero2} es ${
      Number(numero1) + Number(numero2)
    } como resultado`
  );
}

// estacias const
const DNI = "123123A";
const trabajos = [];
//console.log(trabajos);

// datos

// operadores
// += -= *= /= %=
// >= <= == != 1
let numeroLetra = "3";
let numeroNumero = 3;
numeroLetra == numeroNumero; // true --> contenido
numeroLetra === numeroNumero; // false --> contenido y tipo
// && ||

// if else if else
/* if(true)
{}else {

} */
// if ternario
// String valor = condicion ? "SI" : "NO"
// condicion ? true : false
numeroNumero = 20;
numeroNumero > 0
  ? console.log("Numero positivi")
  : console.log("numeronegativo");
(numeroNumero > 0) & console.log("Numero positivi");

// condicion ? true : condicion2 ? true : condicion3 ? true : false
// condicion & true
// switch
// while
// dowhile
// for - foreach
let numeros = [1, 23, 4, 52, 423, 423, 4, 23, 4234, 234];
/* for (let index = 0; index < numeros.length; index++) {
  console.log(numeros[index]);
} */

// for (String i : coleccion){}
// function metodo(){}
// (param1, param2, param3)=>{cuerpo}
// value, index, element
numeros.forEach((_, index) => {
  // una por iteracion
  console.log(`Posicion ${index} : ${_}`);
});

// break
// continue
