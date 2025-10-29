console.log("Ejecicion del fichero");
// clases
// funciones
// variables
// tipo -> primitivo - complejo
// valor -> number boolean char string Object -> lenguaje no tipado
// ambito -> let // var // const
let nombre = "Borja MArtin"; // string
let edad = 42; // number
let altura = 1.73; // number
let letraPiso = "A"; // char - string
let experiencia = true; // bool
let fechaNacimiento = new Date(1984, 2, 21); // Object
let mail = "borja@ue.com"; // string
let puesto = null; // null
let conocimiento; // null
edad = 43;
nombre = "Borja M";
/* const DNI = "123A";
DNI = "123B"; */

/* console.log("Mi nombre es " + nombre);
console.log("Mi edad es " + edad);
console.log("Mi puesto es " + puesto);
console.log("Mi conocimiento es " + conocimiento); */

console.log(`Mi nombre es ${nombre}`);
console.log("El tipo de la edad es " + typeof edad); // int
console.log("El tipo de la altura es " + typeof altura); // double
console.log("El tipo del puesto es " + typeof puesto); // null
console.log("El tipo del conocimiento es " + typeof conocimiento); // undefined
// NaN -> Not a Number

/* if (numero < 10) {
  var numero = 5;
  console.log("Este numero es inferior");
  numero = 20;
}
console.log(numero); */
