console.log("Código ejecutado desde el fichero js externo");
console.log("Segunda línea del fichero js externo");

// NO TIPADO
// segun su posibilidad de cambio final -> constante
const DNI = "12456789A";
// segun su ambito de accion -> desde donde se pueden acceder
var nombre = "Borja";
if (true) {
  console.log(nombre);
  var edad = 40;
  let correo = "borja@correo.com";
}

let correo = "micorreo@gmail.com";
console.log(edad);
console.log(correo);

let numero = 6;
numero = 4.8;
console.log(typeof numero);

// segun el dato que guarda -> primarias / complejas
// numeros -> int -> number (int, float, double, byte)
// palabras -> String -> string
// boolean -> boolean
// char -> string
// Array -> Array estáticos -> Object
// null -> null
// let nombre = null; null
// let nombre; undefined
// String nombre; // null
// nombre.length
// NaN -> Not a Number

/* tener el nodo */
/* obtengo UN nodo que cumpla con el selector (querySelector -> Node)
TAG ("nombre_tag"),
ID ("#id"),
CLASS (".nombreClase")
*/
let parrafo = document.querySelector("#parrafo-uno");
parrafo.textContent = "Cambiando contenido del parrafo mediante JS";
/*SI QUIERO ENCONTRAR UNO TIENE MAS SENTIDO ID*/
let parrafoDos = document.querySelector("#parrafo-dos");
parrafoDos.textContent = "Este cambio va a verse en el parrafo dos";
let parrafoTres = document.querySelector("#parrafo-tres");
parrafoTres.textContent = "Este cambio se muestra en el parrafo tres";

/* obtengo TODOS nodos que cumplan con el selector*/
/* querySelectorAll() -> NodeList */
let parrafos = document.querySelectorAll("p"); // [n1,n2,n3,n4]
/* quiero cambiar el texto de todos los parrafos y ponerlo en cargando */
/* for (let index = 0; index < parrafos.length; index++) {
  parrafos[index].textContent = "cargando";
} */
parrafos.forEach((item, index) => {
  item.textContent = `Cargando parrafo ${index + 1}`;
});

let inputOperando1 = document.querySelector("#input-op1");
let inputOperando2 = document.querySelector("#input-op2");
let botonOperar = document.querySelector("#boton-operar");
let selectOperacion = document.querySelector("#select-operacion");
let textoInput = document.querySelector("#input-texto");
let spanContador = document.querySelector("span");

botonOperar.addEventListener("click", (e) => {
  // lo que quiero que pase cuando se pulse el boton
  operar();
});

selectOperacion.addEventListener("change", (e) => {
  operar();
});

textoInput.addEventListener("keyup", (e) => {
  if (e.target.value.length < 100) {
    spanContador.textContent = e.target.value.length;
  } else {
    e.preventDefault();
  }
});

function operar() {
  if (inputOperando1.value.length > 0 && inputOperando2.value.length > 0) {
    let operacion = Number(selectOperacion.value);
    let resultadoOperacion = 0;
    switch (operacion) {
      case 1:
        resultadoOperacion =
          Number(inputOperando1.value) + Number(inputOperando2.value);
        break;
      case 2:
        resultadoOperacion =
          Number(inputOperando1.value) - Number(inputOperando2.value);
        break;
      case 3:
        resultadoOperacion =
          Number(inputOperando1.value) * Number(inputOperando2.value);
        break;
      case 4:
        resultadoOperacion =
          Number(inputOperando1.value) / Number(inputOperando2.value);
        break;
    }

    parrafoTres.textContent = resultadoOperacion;
  } else {
    alert("No hay datos para operar");
  }
}
/* 
lista = {"asd","asd","asd","asd","asd"}
for( String item : lista ){
  sout(item)
}
*/
