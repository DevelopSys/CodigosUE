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
