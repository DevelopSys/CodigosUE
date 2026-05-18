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
let inputApellido = document.querySelector("#input-apellido");
let inputEdad = document.querySelector("#input-edad");
let inputCurso = document.querySelector("#select-curso");
let inputFecha = document.querySelector("#input-fecha");
let btnEnvio = document.querySelector("#btn-envio");
let btnBorrar = document.querySelector("#btn-vaciar");
let listaUsuarios = document.querySelector("#lista-usuarios");

btnEnvio.addEventListener("click", () => {
  const nombre = inputNombre.value;
  const apellido = inputApellido.value;
  const edad = inputEdad.value;
  const curso = inputCurso.value;
  const fecha = inputFecha.value;

  if (nombre == "" || apellido == "" || edad < 18 || fecha == "") {
    alert("No se puede registrar el usuario");
  } else {
    const nodoLI = document.createElement("li");
    nodoLI.textContent = `${nombre} ${apellido} ${curso}`;
    // nodoLI.className = "list-group-item asd asd asd asd"
    nodoLI.classList.add(
      "list-group-item",
      "mt-2",
      "animate__animated",
      "animate__fadeInRight",
    );
    listaUsuarios.append(nodoLI);
  }

  /*   const li = `<li class='list-group-item animate__animated animate__fadeInRight'>${nombre} ${apellido} ${curso}</li>`;
  listaUsuarios.innerHTML += li; */

  // listaUsuarios.innerHTML = listaUsuarios.innerHTML+ li;
});

btnBorrar.addEventListener("click", () => {
  listaUsuarios.innerHTML = "";
});

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
