let boton = document.querySelector("#boton");
let botonRellenar = document.querySelector("#boton-rellenar");
let input = document.querySelector("#input-nombre");
let inputA = document.querySelector("#input-apellido");
let select = document.querySelector("#select");
let lista = document.querySelector("#lista");
let contenedorCartas = document.querySelector("#contenedor-cartas");

let listaNombre = [];

boton.addEventListener("click", () => {
  listaNombre.push(`${input.value} ${inputA.value} ${select.value}`);
  rellenarLista();
  /* pintarCarta(); */
});

botonRellenar.addEventListener("click", () => {
  // [Borja, Clara, Roberto]
  // 1 ejecucion por cada uno de los elementos de la lista
  // Borja -> ejecucion
  // Clara -> ejecucion
  // Roberto -> ejecucion
  listaNombre.forEach((element, index) => {
    // ejecucion
    // console.log(`En la posicion ${index} está ${element}`);
    lista.innerHTML += `<li>${index} - ${element}</li>`;
  });
});

function rellenarLista() {
  lista.innerHTML = "";
  listaNombre.forEach((element, index) => {
    // ejecucion
    // console.log(`En la posicion ${index} está ${element}`);
    lista.innerHTML += `<li>${index} - ${element}</li>`;
  });
}

function pintarCarta() {
  contenedorCartas.innerHTML = "";
  listaNombre.forEach((element, index) => {
    // ejecucion
    // console.log(`En la posicion ${index} está ${element}`);
    contenedorCartas.innerHTML += `<div class="col">
    <div class="card" style="width: 18rem">
      <img src="..." class="card-img-top" alt="..." />
      <div class="card-body">
        <h5 class="card-title">${element}</h5>
        <p class="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>`;
  });
}

/*

public void miFucnion(String param){
    param
}

*/
