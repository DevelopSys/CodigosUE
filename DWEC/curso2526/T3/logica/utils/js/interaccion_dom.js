// tener el acceso a cada uno de los elementos que estan en el DOM y modificar su comportamiento
// accede a un elemento UNICO
let botonAgregar = document.querySelector("#botonAgregar");
let botonEliminar = document.querySelector("#botonEliminar");
let botonVaciar = document.querySelector("#botonVaciar");
let lista = document.querySelector("#lista");
let inputNombre = document.querySelector("#inputNombre");

// let boton = document.querySelector("button");
// LISTA con un solo boton
/* let items = document.querySelectorAll("#lista li");
items.forEach((item, index) => {
  // console.log("Elemento " + item.textContent);
  item.textContent = `Elemento ${index}`;
}); */
botonAgregar.addEventListener("click", () => {
  // lo que pasará cuando el boton se pulse
  // forma facil
  let contenido = inputNombre.value;
  /* lista.innerHTML += `<li class='animate__animated animate__backInRight list-group-item'>${contenido}</li>`;
  inputNombre.value = ""; */
  // crea un nodo
  if (contenido.length == 0) {
    Swal.fire({
      title: "Error",
      text: "Por favor introduce algo en el nombre",
      icon: "error",
    });
  } else {
    let li = document.createElement("li");
    // configura sus propiedades
    li.classList.add(
      "animate__animated",
      "animate__backInRight",
      "list-group-item"
    );
    li.textContent = contenido;
    let botonLi = document.createElement("button");
    botonLi.classList.add("btn", "btn-danger");
    botonLi.textContent = "Eliminar";
    botonLi.addEventListener("click", () => {
      li.classList.remove("animate__animated", "animate__backInRight");
      li.classList.add("animate__animated", "animate__backOutRight");
      setTimeout(() => {
        li.remove();
      }, 700);
    });
    li.appendChild(botonLi);
    lista.append(li);
    inputNombre.value = "";
  }
});

botonEliminar.addEventListener("click", () => {
  // lo que pasará cuando el boton se pulse
  let nodo = lista.childNodes()[0];
  nodo.remove();
});

botonVaciar.addEventListener("click", () => {
  // lo que pasará cuando el boton se pulse
  lista.classList.add("animate__animated", "animate__wobble");
  setTimeout(() => {
    lista.innerHTML = "";
  }, 700);
});
