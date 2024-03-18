let lista = [];
let contador = 0;
let sobreescribir = false;
// añadir
// lista.push añade elementos al final
// lista.unshift añade elementos al principio
// borrar
// lista.pop elimina el elemento del final
// lista.shift elimina el elemento del principio
let boton = document.querySelector("#boton");
let botonBorrar = document.querySelector("#boton-borrar");
let botonListar = document.querySelector("#boton-listar");
let listaUL = document.querySelector("#lista");

document.querySelector("#boton-borrar").addEventListener("click", () => {
  if (
    lista.find((element) => {
      return element == "Pedro";
    }) != null
  ) {
  }

  lista.unshift(`Elemento ${contador}`);
  contador++;
  console.log(lista);
  listaUL.innerHTML += `<li>${lista[0]}</li>`;
});

botonBorrar.addEventListener("click", () => {
  if (lista.length > 0) {
    lista.shift();
    contador--;
    console.log(lista);
  } else {
    console.log("No hay cosas en la lista");
  }

  sobreescribir = true;
});

botonListar.addEventListener("click", () => {
  // [1,2,3,4,5,6,7,8,9,10]

  if (sobreescribir == false) {
    lista.forEach((element) => {
      listaUL.innerHTML += `<li>${element}</li>`;
    });
  } else {
    listaUL.innerHTML = "";
    lista.forEach((element) => {
      listaUL.innerHTML += `<li>${element}</li>`;
    });
  }
});
