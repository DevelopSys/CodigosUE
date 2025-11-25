// tener el acceso a cada uno de los elementos que estan en el DOM y modificar su comportamiento
// accede a un elemento UNICO
let botonAgregar = document.querySelector("#botonAgregar");
let botonEliminar = document.querySelector("#botonEliminar");
let botonVaciar = document.querySelector("#botonVaciar");
let botonUsuarios = document.querySelector("#botonUsuarios");
let lista = document.querySelector("#lista");
let listaUsuarios = document.querySelector("#listaUsuarios");
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputCorreo = document.querySelector("#inputCorreo");
let inputFecha = document.querySelector("#inputFecha");
let usuarios = [];

// let boton = document.querySelector("button");
// LISTA con un solo boton
/* let items = document.querySelectorAll("#lista li");
items.forEach((item, index) => {
  // console.log("Elemento " + item.textContent);
  item.textContent = `Elemento ${index}`;
}); */
botonUsuarios.addEventListener("click", () => {
  /* let usuario = new Usuario();
  usuario.setNombre = "asdasd"
  // limpiarDatos[0].setCorreo("prueba@hotmail.com");

  console.log(
    `Los datos del primer usuarios con ${listaUsarios[0].getDominio()}`
  ); */
  this.usuarios = _.shuffle(this.usuarios);
  console.log(this.usuarios);

  let ejecucionRecurrente = setInterval(() => {
    agregarNodoUsuario(usuarios.pop());
    if (usuarios.length == 0) {
      clearInterval(ejecucionRecurrente);
    }
  }, 3000);

  botonUsuarios.enable = false;
  // ejecucionRecurrente();
});

botonAgregar.addEventListener("click", () => {
  /* 
  // lo que pasará cuando el boton se pulse
  // forma facil
  let contenido = inputNombre.value;
  lista.innerHTML += `<li class='animate__animated animate__backInRight list-group-item'>${contenido}</li>`;
  inputNombre.value = "";
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
  } */
  // crearme un objeto de tipo usuario
  let usuario = new Usuario(
    inputNombre.value,
    inputApellido.value,
    inputCorreo.value,
    inputFecha.value
  );
  agregarUsuario(usuario);
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

function agregarUsuario(usuario, posicion = 1) {
  // no quiero agregar el usuario si ya existe ese correo
  let usuarioEncontrado = usuarios.find((item) => {
    return item.getCorreo() == usuario.getCorreo();
  });
  if (usuarioEncontrado != undefined) {
    Swal.fire({
      title: "Usuario?",
      text: "El usuario ya existe",
      icon: "error",
    });
  } else {
    usuarios.push(usuario);
    limpiarDatos();
  }
}

function agregarNodoUsuario(usuario) {
  // no quiero agregar el usuario si ya existe ese correo
  listaUsarios.innerHTML += `<li class='list-group-item'>${usuario.mostrarDatos()}</li>`;
}

function limpiarDatos() {
  inputApellido.value = "";
  inputNombre.value = "";
  inputCorreo.value = "";
  inputFecha.value = "";
}
