console.log("Ejecutando codigo JS");

let usuarios = ["usuario1 mkt", "usuario2 it", "usuario 3 fin", "usuario4 mkt"];

usuarios.forEach((element) => {
  if (element.includes("it")) {
    console.log(element);
  }
});

/* gestionar la pulsacion del boton */
// boton-> #y el id
// .nombre clase
// nombre etiqueta

let boton = document.querySelector("#botonIniciar");
let inputNombre = document.querySelector("#input-nombre");
let parrafoSaludo = document.querySelector("#parrafo-saludo");
let listaSaludos = document.querySelector("#lista-saludos");
let selectOpciones = document.querySelector("#select-opciones");

boton.addEventListener("click", () => {
  if (inputNombre.value.length == 0) {
    alert("No hay a aquien saludar");
  } else {
    realizarSaludo(inputNombre.value, selectOpciones.value);
    guardarSaludo(inputNombre.value);
    inputNombre.value = "";
  }
});

function realizarSaludo(nombre, opcion) {
  parrafoSaludo.textContent = `Hola ${nombre} acabas de lanzar un saludo y tu opcion seleccionada es ${opcion}`;
}

function guardarSaludo(nombre) {
  // modificar el innerHTML de la lista -> el html interno dentro del nodo UL
  // listaSaludos.innerHTML += `<li>${nombre}</li>`;
  let nodo = document.createElement("li");
  nodo.textContent = nombre;
  nodo.classList.add("list-group-item");
  // <li class="list-group-item">asdasdad</li>
  nodo.className = "list-group-item";

  listaSaludos.append(nodo);
}

/* function pulsacion() {
  console.log("Boton pulsado 1");
  console.log("Boton pulsado 2");
  console.log("Boton pulsado 3");
  console.log("Boton pulsado 4");
  console.log("Boton pulsado 5");
  console.log("Boton pulsado 6");
}
 */
