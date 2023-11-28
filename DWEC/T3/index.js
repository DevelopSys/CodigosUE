/* Los elementos se pueden buscar: tag, class, id */
/* document.getElementsByClassName("list-group");
document.getElementById("lista_elementos");
document.getElementsByTagName("ul"); */
/* document.querySelectorAll(".list-gropu")
document.querySelectorAll("ul")
document.querySelector("#lista_ementos") */

/* dame todos los li que esten dentro de un ul que tenga un id de lista_uno y ademas sean de class active */
/* li que sean active y que esten en un ul con id lista_uno */
/* let nodosLI = document.querySelectorAll("ul#lista_uno li.active");
nodosLI.forEach((element) => {
  //console.log(element.className);
  element.classList.remove("active");
});
 */

let boton = document.querySelector("#boton_pulsar");
let botonBorrar = document.querySelector("#boton_borrar");
let botonContenido = document.querySelector("#boton_contenido");
let lista = document.querySelector("#lista_uno");
botonContenido.addEventListener("click", () => {
  console.log(document.querySelector("#lista_dos .active").textContent);
});

botonBorrar.addEventListener("click", (e) => {
  document.querySelectorAll("#lista_uno li.active").forEach((element) => {
    lista.removeChild(element);
  });
});

boton.addEventListener("click", (e) => {
  /* añadir un elemento a la lista */
  /* sencilla */
  //lista.innerHTML += "<li class='list-group-item'>Elemento añadido</li>";
  let nodoLI = document.createElement("li");
  nodoLI.textContent = "Elemento añadido";
  nodoLI.classList.add("list-group-item", "active");
  lista.appendChild(nodoLI);
});
