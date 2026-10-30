// ejemplo de comientario en fichero externo
console.log("Este mensaje se lanza desde un js externo al html");
// variables -> nombre = valor;
// string number boolean Object Array null undefined
// const -> final
// let var
const DNI = "A";
let altura = 1.75;
let nombre = "Borja";
let apellido = "Martin";
let acierto = false;
let fechaNacimiento = new Date(2025, 7, 15);
let direccion = null;
let telefono;
let parrafo = document.querySelector("p");
let boton = document.querySelector("button");
let lista = document.querySelector("ul");
boton.addEventListener("click", () => {
  // parrafo.innerText = "Este parrafo lo cambio yo desde JS";
  lista.innerHTML += '<li class="list-group-item">Elemento desde JS</li>';
});

console.log("Mi direccion es " + direccion);
console.log("Mi telefono es " + telefono);

if (false) {
  var cosaGeneral = "Esta variable tiene ambito muy grande";
  let edad = 42;
  console.log(`Mi edad es de ${edad}`);
}
console.log(`Procedemos a imprimir algo general ${cosaGeneral}`);
