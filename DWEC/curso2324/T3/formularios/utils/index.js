import { Usuario } from "./user";

let boton = document.querySelector("button");
let botonGuardar = document.querySelector("#botonGuardar");
let botonBorrar = document.querySelector("#botonBorrar");
let botonRecuperar = document.querySelector("#botonRecuperar");
let inputNombre = document.querySelector("#inputMail");
let inputPass = document.querySelector("#inputPass");
let inputCheck = document.querySelector("#inputCheck");
let lista = document.querySelector("#listaUsuarios");
let select = document.querySelector("select");

inputNombre.addEventListener("keyup", (e) => {
  console.log(e.target.value.length);
});

select.addEventListener("change", (e) => {
  console.log(select.value);
});

boton.addEventListener("click", (e) => {
  //console.log(e);
  console.log(select.value);
  lista.innerHTML += `<li>${inputNombre.value} ${inputPass.value}</li>`;
});

botonBorrar.addEventListener("click", (e) => {
  localStorage.removeItem(inputNombre.value);
});

botonGuardar.addEventListener("click", (e) => {
  //localStorage.setItem(inputNombre.value, "nombre");
  let usuario = new Usuario(inputNombre.value, inputPass.value);
  localStorage.setItem(inputNombre.value, JSON.stringify(usuario));
});

botonRecuperar.addEventListener("click", (e) => {
  console.log(JSON.parse(localStorage.getItem(inputNombre.value)));
});

fetch("https://dummyjson.com/products")
  .then((res) => res.json())
  .then(console.log);

// nombre - pass
