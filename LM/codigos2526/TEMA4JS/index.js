// sacar un mensaje por consola
// console.log("Esta mensaje es para ver si todo esta OK");
// let para poder crear variables (que pueden cambiar)
// buscar por etiqueta let parrafo = document.querySelector("p")
// buscar por el nombre de la clase let parrafo = document.querySelector(".btn")
// let botones = document.querySelectorAll(".btn");
// console.log(botones);
// parrafo.innerText = "Este parrafo lo cambio desde JS";
// defino las variables
let parrafo = document.querySelector("#parrafo-nombre");
let botonSaludar = document.querySelector("#boton-saludar");
let botonDespedir = document.querySelector("#boton-despedir");
let inputNombre = document.querySelector("#input-nombre");

botonSaludar.addEventListener("click", () => {
  let nombre = inputNombre.value;
  if (nombre != "") {
    // solo quiero hacer esto si me han puesto un nombre
    parrafo.innerText = `Enhorabuena ${nombre} has completado la tarea`;
  } else {
    alert("Los datos no estan completos");
  }
});

botonDespedir.addEventListener("click", () => {
  parrafo.innerText = "";
  inputNombre.value = "";
});
