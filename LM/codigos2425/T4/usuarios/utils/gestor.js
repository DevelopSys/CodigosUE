let inputNombre = document.querySelector("input#input-nombre");
let inputApellido = document.querySelector("input#input-apellido");
let inputBuscar = document.querySelector("input#input-buscar");
let boton = document.querySelector("#boton-agregar");
let botonBuscar = document.querySelector("#boton-buscar");
let listaUsuarios = document.querySelector("#lista-usuarios");
let listaBuscar = document.querySelector("#lista-busqueda");
let listaUsuariosDatos = []; // Array -> ArrayList

// agregar cosas por detras o por delante
// eliminar cosas por detras o por delante

boton.addEventListener("click", () => {
  // agrega
  //listaUsuariosDatos.push("Borja", "Maria", "Juan", "Maria", "Luis");
  //listaUsuariosDatos.unshift("Jose"); // [u0,u1,u2,u3,u4]

  // eliminar
  //listaUsuariosDatos.pop();
  //listaUsuariosDatos.shift(); //[u1,u2,u3]

  // busquedas
  /* listaUsuariosDatos.forEach((item, index) => {
    // ejecutar una vez por cada elemento del array
    console.log(`${index} ${item}`);
  }); */

  // de un elemento -> find

  /* let usuarioBuscado = listaUsuariosDatos.find((item) => {
    return item == "Jose";
  });

  if (usuarioBuscado != null) {
    console.log(usuarioBuscado);
  } else {
    console.log("El usaurio no esta en la lista");
  } */

  // de elementos -> filter

  /*   let nombreBuscar = prompt("Introduce el nombre que quieres buscar");

  let listaResultante = listaUsuariosDatos.filter((item) => {
    return item == nombreBuscar;
  });

  if (listaResultante.length > 0) {
    listaResultante.forEach((item) => {
      console.log(item);
    });
  } else {
    console.log("No hay elementos con la letra indicada");
  } */

  /* cuando no quiero añadir???? */
  if (inputNombre.value.length > 0 && inputApellido.value.length > 0) {
    //listaUsuarios.innerHTML += `<li class='animate__animated animate__zoomInUp list-group-item'>${inputNombre.value} ${inputApellido.value}</li>`;
    listaUsuariosDatos.push(`${inputNombre.value} ${inputApellido.value}`);
    let nodo = document.createElement("li");
    nodo.textContent = `${inputNombre.value} ${inputApellido.value}`;
    nodo.className = "animate__animated animate__zoomInUp list-group-item";
    nodo.addEventListener("click", () => {
      nodo.classList.remove("animate__animated");
      nodo.classList.remove("animate__zoomInUp");
      nodo.classList.add("animate__animated");
      nodo.classList.add("animate__bounce");
    });
    listaUsuarios.append(nodo);
    inputApellido.value = "";
    inputNombre.value = "";

    Swal.fire({
      title: "Correcto",
      text: "Usuario agregado correctamente",
      icon: "success",
      confirmButtonText: "Cool",
    });
  } else {
    Swal.fire({
      title: "Error",
      text: "Faltan datos",
      icon: "error",
      timer: 1500,
    });
  }
});

botonBuscar.addEventListener("click", () => {
  let listaBusqueda = listaUsuariosDatos.filter((item) => {
    return item.includes(inputBuscar.value);
  });
  console.log(listaUsuariosDatos);
  console.log(listaBusqueda);

  listaBuscar.innerHTML = "";
  listaBusqueda.forEach((item) => {
    listaBuscar.innerHTML += `<li class='list-group-item'>${item}<li>`;
  });
});
