/* para poder acceder a nodos
- etiqueta: tag -> generalista
- class: .clase -> generalista
- id: #id -> único

document.getElementById("id_buscar")
document.getElementsByClassName("clase_buscar")
document.getElementsByTagName("tag_buscar")
Elemento único si es getElement, elemento Multiple si es getElements -> HTMLELEMENT o HTMLCOllection

document.querySelector("tag") 
document.querySelector("#id") 
document.querySelector(".clase") 
document.querySelectorAll(".clase")  -> Node o NodeList

document.querySelector("div.container ul#lista-elementos li.seleccionado[img='./imagen.jpg']")
document.querySelector("div.container form input[type=radio]::selected")
document.querySelector(".datos input[type=radio]::selected")
*/
let contador = 0;
let botonAnalizar = document.querySelector("#botonAnalizar");
let botonAnadir = document.querySelector("#botonAnadir");
let inputNombre = document.querySelector("#inputNombre");
let parrafoContador = document.querySelector("#contador");
/* botonAnalizar.className = "btn btn-danger"; */
botonAnalizar.addEventListener("click", (event) => {
  /* Lo que quiero que pase cuando el boton se pulsa */
  let nodos = document.querySelectorAll("li");
  nodos.forEach((element) => {
    // element.className = "list-group-item active";
    console.log(element.textContent);
  });
});

botonAnadir.addEventListener("click", (event) => {
  /* Lo que quiero que pase cuando el boton se pulsa */
  let nombre = inputNombre.value;
  if (nombre.length == 0) {
    alert("No hay nombre para añadir");
  } else {
    let lista = document.querySelector("ul");
    lista.innerHTML += `<li class='list-group-item'>Nombre: ${nombre}</li>`;
    inputNombre.value = "";
    contador++;
    parrafoContador.textContent = contador;
  }
});
