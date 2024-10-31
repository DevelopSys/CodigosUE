let nombre = "Borja";

console.log(`Hola ${nombre} este es el primer programa en JS`);
// interaccion del usuario
// alert(`Bienvenido ${nombre} a la pagina`); -> saca info sin posibilidad a hacer nada
/*let edad = Number(prompt("Por favor introduce tu edad")); // string -> pide informacion
if (isNaN(edad)) {
  alert("Dato incorrecto");
} else {
  alert(`Tu edad es de ${edad}`);
}*/
/*let continuar = confirm("Estas seguro que quieres continuar?"); // boolean -> pregunta y responde true o false
if (continuar) {
  let edad = Number(prompt("Por favor introduce tu edad")); // string -> pide informacion
  if (isNaN(edad)) {
    alert("Dato incorrecto");
  } else {
    alert(`Tu edad es de ${edad}`);
  }
} else {
  alert("No quieres continuar");
}*/
/* Swal.fire({
  title: "Do you want to save the changes?",
  showDenyButton: true,
  showCancelButton: true,
  confirmButtonText: "Save",
  denyButtonText: `Don't save`,
}).then((result) => {
  /* Read more about isConfirmed, isDenied below 
  if (result.isConfirmed) {
    Swal.fire("Saved!", "", "success");
  } else if (result.isDenied) {
    Swal.fire("Changes are not saved", "", "info");
  }
}); */

// los metodos en java tenian que estar dentro de LAS CLASES
// function nombre(){
// }

// saludar(nombre);
// console.log(sumar(4, 7));
// parametros posicionales
// console.log(sumar(4));
// console.log(sumar(6));
// console.log("Vamos a multiplicar dos numeros");
// multiplicar(4, 6, 8, 9, 6);–
let sumaFlecha = (param1, param2) => {
  console.log(param1 + param2);
};
let restaFlecha = (param1, param2) => {
  console.log(param1 - param2);
  return 5;
};
// en el cuerpo si no pongo {}, es de una sola linea en el cuerpo, y esta es el retorno

// sumaFlecha(4, 6);
console.log(restaFlecha(4, 2));

function saludar(nombre) {
  console.log(`Hola ${nombre}, primera funcion realizada`);
}

function sumar(param1, param2 = 0) {
  // 4 + undefined = NaN
  console.log(`Parametro 1 ${param1} Parametro 2 ${param2}`);
  return param1 + param2;
}

function multiplicar(param1, param2) {
  console.log(param1 * param2);
  // argumentos invisibles
  console.log(arguments.length);
}

// arrow function -> lambda. escrita de forma muy rapida, centrada en el cuerpo
// let variable = (param1, param2, param3) => {cuerpo de la funcion}
