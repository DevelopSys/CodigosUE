let botonS = document.querySelector("#boton-saludar");
let botonD = document.querySelector("#boton-despedir");
let botonA = document.querySelector("#boton-anadir");
let lista = document.querySelector("#lista");

botonS.addEventListener("click", () => {
  //console.log("asdasd");
  funcionSaludar("Virginia", (p) => {
    console.log(`Bienvenida ${p}`);
  });
});

botonD.addEventListener("click", () => {
  //console.log("asdasd");
  funcionSaludar("Virginia", (p) => {
    console.log(`Hasta luego ${p}`);
  });
});

botonA.addEventListener("click", () => {
  /* let nodoLI = document.createElement("li");
  nodoLI.textContent = "Nodo LI nuevo";
  lista.append(nodoLI); */
  lista.innerHTML += "<li>NODO NUEVO</li>";
});

function funcionSaludar(p1, p2) {
  p2(p1);
}
