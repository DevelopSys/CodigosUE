console.log("Esto es mi codigo JS");
// comentarios
/* lineas multiples */
// variables que existen
// no indico tipos en la variable -> JS es un lenguaje NO TIPADO
// constante (final) -> const
const NOMBRE_ASIGNATURA = "Desarrollo Cliente";
const elementos = [];

// variables ambito bloque -> let
// variable global -> var

if (true) {
  let nombre = "Borja";
  nombre = "Juan";
  // var apellido = "Martin";
}
//console.log(apellido);

let nombre = "Borja"; // string
let edad = 40; // number
let altura = 1.74; // number
let experiencia = true; // bool
let fechaNacimiento = new Date(); // Object - Date
let asignaturas = []; // array - arraylist
let sinValor = null; // null
let sinDefinir; // undefined
// NaN -> Not a Number

console.log(typeof nombre);
console.log(typeof edad);
console.log(typeof altura);
console.log(typeof experiencia);
console.log(typeof fechaNacimiento);
console.log(typeof asignaturas);
console.log(typeof sinDefinir);
console.log(typeof sinValor);
