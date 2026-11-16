// let botonAgregar = document.getElementsByTagName("button");
let botonAgregar = document.querySelector("#btnAgregar");
let botonVaciar = document.querySelector("#btnVaciar");
let botonConsultar = document.querySelector("#btnConsultar");
let inputNombre = document.querySelector("#inputNombre");
let inputMail = document.querySelector("#inputMail");
let inputEdad = document.querySelector("#inputEdad");
let selectCurso = document.querySelector("#selectCurso");
let listaUsuarios = document.querySelector("#listaUsuarios");
let usuarios = [];
// pop push shift unshift
/* let botones = document.querySelectorAll("button");
let controles = document.querySelectorAll(".form-control");
console.log(botonAgregar);
console.log(botones);
console.log(controles); */
botonAgregar.addEventListener("click", (e) => {
  addListener(e);
});
botonVaciar.addEventListener("click", (e) => {
  addListener(e);
});
botonConsultar.addEventListener("click", (e) => {
  addListener(e);
});

function addListener(e) {
  // comun
  switch (e.target.id) {
    case "btnConsultar":
      console.log(usuarios);
      usuarios.forEach((item) => {
        console.log(item.nombre);
      });
      break;
    case "btnVaciar":
      console.log("Pulsado vaciar");
      listaUsuarios.innerHTML = "";
      usuarios = [];
      break;
    case "btnAgregar":
      let nombre = inputNombre.value;
      let edad = inputEdad.value;
      let mail = inputMail.value;
      let curso = selectCurso.value;

      console.log(
        `Los datos son nombre: ${nombre} edad: ${edad} correo: ${mail} curso: ${curso}`,
      );

      if (nombre.length == 0 || edad.length == 0 || mail.length == 0) {
        Swal.fire({
          title: "Fallo",
          text: "Faltan datos en el formulario",
          icon: "warning",
        });
      } else {
        Swal.fire({
          title: "Estas seguro que quieres agregar?",
          showCancelButton: true,
          confirmButtonText: "SI",
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("Guardado", "", "success");
            /* inputEdad.value = "";
            inputMail.value = "";
            inputNombre.value = ""; */
            // listaUsuarios.innerHTML += `<li class="list-group-item">Nombre: nombre: ${nombre} edad: ${edad} correo: ${mail} curso: ${curso}</li>`;

            let nodoLI = document.createElement("li");
            nodoLI.classList.add("list-group-item");
            nodoLI.textContent = `Nombre: nombre: ${nombre} edad: ${edad} correo: ${mail} curso: ${curso}`;
            listaUsuarios.append(nodoLI);
            usuarios.push(new usuario(nombre, mail, edad, curso));
          }
        });
      }

      break;
  }
}
