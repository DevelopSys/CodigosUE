let boton = document.querySelector("#boton-add");
let inputNombre = document.querySelector("#input-nombre");
let inputApellido = document.querySelector("#input-apellido");
let inputCorreo = document.querySelector("#input-correo");
let selectDpto = document.querySelector("#select-dpto");
let lista = document.querySelector("#lista-trabajadores");
let usuariosIT = [];
let usuariosAdmin = [];
let usuariosMkt = [];
let usuariosVentas = [];
boton.addEventListener("click", (e) => {
  agregarTrabajadaror();
});

function agregarTrabajadaror() {
  if (
    inputNombre.value.length > 0 &&
    inputCorreo.value.length > 0 &&
    inputApellido.value.length > 0
  ) {
    let nodo = document.createElement("li");
    nodo.textContent = `${inputNombre.value} ${inputApellido.value}`;
    nodo.className = "list-group-item animate__animated animate__fadeInUp";
    lista.appendChild(nodo);

    switch (selectDpto.value) {
      case "Administracion":
        usuariosAdmin.push(`${inputNombre.value} ${inputApellido.value}`);
        break;
      case "IT":
        usuariosIT.push(`${inputNombre.value} ${inputApellido.value}`);
        break;
      case "Ventas":
        usuariosVentas.push(`${inputNombre.value} ${inputApellido.value}`);
        break;
      case "Marketing":
        usuariosMkt.push(`${inputNombre.value} ${inputApellido.value}`);
        break;
    }

    Swal.fire({
      title: "Usuario agregado",
      text: "Usuario agregado correctmente a la lista",
      icon: "success",
      timer: 2000,
    });

    resetearCampos();
    actualizarContadores();
  } else {
    Swal.fire({
      title: "Error",
      text: "Falta algún tipo de dato, por favor rellena todos los campos",
      icon: "error",
      timer: 3000,
      showConfirmButton: true,
    });
  }
}

function resetearCampos() {
  inputNombre.value = "";
  inputApellido.value = "";
  inputCorreo.value = "";
  selectDpto.value = "Administracion";
}

function actualizarContadores() {
  document.querySelector("#span-admin").textContent = usuariosAdmin.length;
  document.querySelector("#span-it").textContent = usuariosAdmin.length;
  document.querySelector("#span-mkt").textContent = usuariosAdmin.length;
  document.querySelector("#span-ventas").textContent = usuariosAdmin.length;
}
