let bAnadir = document.querySelector("#btnAgregar");
let bBorrar = document.querySelector("#btnEliminar");
let bObtener = document.querySelector("#btnObtener");
let bEstilo = document.querySelector("#btnEstilo");
let parrafo = document.querySelector("p");
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputPass = document.querySelector("#inputPass");
let listaUsuarios = [];
let estilo = localStorage.getItem("clase");
if (estilo != null) {
  bEstilo.classList.remove("btn-primary");
  bEstilo.classList.add(estilo);
  // name=asdasd;value=asdasd;expiration=23456789
}

bAnadir.addEventListener("click", () => {
  let usuario = {
    nombre: inputNombre.value,
    apellido: inputApellido.value,
    pass: inputPass.value,
  };
  listaUsuarios.push(usuario);
  inputPass.value = "";
  inputApellido.value = "";
  inputNombre.value = "";
  localStorage.setItem("usuarios", JSON.stringify(listaUsuarios));
  // usuario.pass
  /* let usuario1 = new usuario(
    inputNombre.value,
    inputApellido.value,
    inputPass.value
  ); */
  /* 
  JavaScriptObjectNotation -> 
  let usuario = {
    clave: valor,
    clave: valor,
    clave: valor,
    clave: valor,
    clave: valor,
    clave: { nombre:asdasd,experiencia:asdas },
  }
  */
  // localStorage.setItem("usuario", JSON.stringify(usuario));
  /* localStorage.setItem("nombre", inputNombre.value);
  localStorage.setItem("apellido", inputApellido.value);
  localStorage.setItem("pass", inputPass.value); */
});
bBorrar.addEventListener("click", () => {
  localStorage.removeItem("apellido");
});
bObtener.addEventListener("click", () => {
  // parrafo.textContent = localStorage.getItem("nombre");
  // console.log(typeof localStorage.getItem("usuario"));
  listaUsuarios = JSON.parse(localStorage.getItem("usuarios"));
  parrafo.textContent = listaUsuarios.length;
});
bEstilo.addEventListener("click", () => {
  localStorage.setItem("clase", "btn-danger");
});
