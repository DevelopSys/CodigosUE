// res -> la funcion que se ejecuta cuando la promesa se resuelve de forma OK
// rej -> la funcion que se ejecuta cuando la promesa se resuelve de forma NO OK
// alert("Mensaje de dialogo");

/* let promesa = new Promise((res, rej) => {
  // generamos un numero entre 0,10
  // esperamos 5
  let numero = Math.random() * 10;
  console.log(`El numero es ${numero}`);
  console.log("Esperando contestacion");

  setTimeout(() => {
    if (numero >= 5) {
      // en caso de ser mayor de 5 resolvemos de forma correcta
      res(numero);
    } else {
      // en caso de ser menor de 5 resolvemos incorrecto
      if (numero > 3) {
        rej("Casi has alcanzado el numero");
      } else {
        rej("Te has quedado muy lejos");
      }
      rej();
    }
  }, 3000);
});

promesa
  .then((data) => {
    console.log(`Numero generado mayor que 5, el resultado es ${data}`);
  })
  .catch((error) => {
    console.log(error);
  }); */
// resultado ok -> then
// resultado no ok -> catch

const lista = document.querySelector("#lista-usuarios");

let url = "https://dummyjson.com/users";
/* fetch(url)
  .then((res) => {
    return res.json();
  })
  .then((res1) => {
    res1.users.forEach((element) => {
      lista.innerHTML += `<div class="col">
          <div class="card">
            <img src="${element.image}" class="card-img-top" alt="..." />
            <div class="card-body">
              <h5 class="card-title">${element.firstName} ${element.lastName}</h5>
              <p class="card-text">
                ${element.address.address} ${element.address.city}
              </p>
              <button class='btn btn-primary'>Comprar</button>
            </div>
          </div>
        </div>`;
      let nodo = document.createElement("li");
      nodo.classList.add(
        "list-group-item",
        "animate__animated",
        "animate__fadeInRight",
      );
      nodo.innerText = `${element.firstName} ${element.lastName}`;
      setTimeout(() => {
        lista.appendChild(nodo);
      }, 2000); 
      // lista.innerHTML += `<li class='list-group-item'>${element.firstName} ${element.lastName}</li>`;
    });
  })
  .catch((err) => {
    console.log("El servidor retorna un error");
    console.log(err);
  }); */

async function resolverPromensa(url) {
  let datos = await fetch(url);
  let datosJSON = await datos.json();
  console.log(datosJSON.users);
}

async function resolverPromensaThen(url) {
  let datos = await fetch(url);
  let datosJSON = await datos.json();
  return datosJSON;
}

resolverPromensa(url).then().catch();
