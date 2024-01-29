let botonAnadir = document.querySelector("#anadir");
let botonBorrar = document.querySelector("#borrar");
let botonBuscar = document.querySelector("#buscar");
let botonActualizar = document.querySelector("#actualizar");
let resultados = document.querySelector("#resultados");

botonBuscar.addEventListener("click", () => {
  // buscar todos los usuarios
  // los añadas a la lista de resultados
  resultados.innerHTML = "";
  consultarUsuarios("female");
});

botonAnadir.addEventListener("click", () => {
  agregarUsuario();
});

botonActualizar.addEventListener("click", () => {
  fetch("http://127.0.0.1:3000/users/add", { method: "POST" });
});

/* let promesa = new Promise((res, rej) => {
  // cuando todo ok
  res(1);
  // cuando algo mal
  rej(2);
});

promesa.then((p1)=>{

}).catch((p2)=>{

}) */

/* fetch("https://dummyjson.com/users")
  .then((res) => res.json())
  .then((res1) => {
    console.log(res1);
  }); */

async function consultarUsuarios(genero) {
  let resultadoJSON = await fetch("https://dummyjson.com/users");
  let resultadoReal = await resultadoJSON.json();
  resultadoReal.users
    .filter((element) => element.gender == genero)
    .forEach((element) => {
      console.log(element);
      resultados.innerHTML += `<div class="col">
    <div class="card" style="width: 18rem">
      <img src="${element.image}" class="card-img-top" alt="..." />
      <div class="card-body">
        <h5 class="card-title">${element.firstName} ${element.lastName}</h5>
        <p class="card-text">
          ${element.address.city}
        </p>
        <a href="#" class="btn btn-primary">Ver detalle</a>
      </div>
    </div>
  </div>`;
    });
}

async function agregarUsuario() {
  let resultadoJSON = await fetch("https://dummyjson.com/users/add", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      firstName: "Nombre",
      lastName: "Apellido",
      age: 30,
    }),
  });
  let resultadoReal = await resultadoJSON.json();
  console.log(resultadoReal);
}
