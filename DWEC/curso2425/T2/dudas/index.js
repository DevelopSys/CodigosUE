// let operado1 = Number(prompt("Introduce el numero 1")); // 9
// let operado2 = Number(prompt("Introduce el numero 2")); // NaN
let numero = 123123;
// number -> string -> []
// 1 2 3 1 2 3
let sumatorio = 0;
numero
  .toString()
  .split("")
  .forEach((item) => {
    // console.log(Number(item));
    sumatorio += Number(item);
    console.log(sumatorio);
  });

// console.log(sumatorio);

let numeros = [1, 3, 4, 5, 6, 7, 8, 9];
// console.log(numeros);
let carta1 = "2C";
let valor = 1;
let palo = "C";
//Valor: 1
//Palo: C
//Carta: 1C
alert(`Valor: ${valor}\nPalo: ${palo}\nCarta:${carta1}`);

new Usuario("Borja",23,1.79)

/* 
{
nombre: "Borja",
edad: 23,
altura: 1.79
}
*/

let imagen = document.createElement("img");
imagen.src = `./images/${carta1}.jpg`;
imagen.textContent = "asdadsasd";
imagen.innerHTML = "asdasdasd";
document.querySelector("#tapete").append(imagen);

// operacionSuma(operado1, operado2);

function operacionSuma(param1, param2) {
  // en el caso de que pase 1 o más de dos parámetros la ejecución saltará un error de excepción
  // arguments[]

  if (arguments.length < 2 || arguments.length > 2) {
    alert("Error hay mas o menos argumentos de los necesarios");
    for (let index = 0; index < arguments.length; index++) {
      const element = arguments[index];
      console.log(element);
    }
  } else {
    if (!isNaN(param1) && !isNaN(param2)) {
      alert(
        `Los operadores son ${param1} ${param2} y la suma es ${param1 + param2}`
      );
    } else {
      alert("alguno de los datos es incorrecto");
    }
  }
}
