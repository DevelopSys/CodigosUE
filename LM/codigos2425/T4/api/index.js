// JSON -> javascript object notation
// {} -> es un objeto
// [] -> es un array
// [ {}, {}, {}] -> es un array de objetos
/* par clave valor (string, number, array, objecto, boolean)
{
    clave: valor,
    calve: valor;
}
*/

let lista = document.querySelector("#lista");
let fila = document.querySelector("#fila");

let objeto = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 40,
  carnet: true,
  conocimientos: ["programacion", "3d", "sistemas", "gestion"],
};

let usuarios = [
  {
    nombre: "Juan",
    apellido: "Gomez",
    edad: 40,
    carnet: false,
    conocimientos: ["sistemas", "ventas"],
    proyectos: [{ nombre: "mejorar departamento", presupuesto: 30000 }],
  },
  {
    nombre: "Celia",
    apellido: "Martin",
    edad: 20,
    carnet: false,
    conocimientos: ["sistemas", "ventas"],
    proyectos: [{ nombre: "mejorar departamento", presupuesto: 30000 }],
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    edad: 40,
    carnet: true,
    conocimientos: ["programacion", "3d", "sistemas", "gestion"],
    proyectos: [
      { nombre: "desarrollo de una web", presupuesto: 1000 },
      { nombre: "desarrollo app movil", presupuesto: 20000 },
    ],
  },
  {
    nombre: "Claudia",
    apellido: "Martin",
    edad: 30,
    carnet: true,
    conocimientos: ["programacion"],
  },
];

/* usuarios.forEach((item) => {
  lista.innerHTML += `<li>${item.nombre} ${item.apellido}</li>`;
}); */

// contesta bien o mal
// contestara?
fetch("https://dummyjson.com/users")
  .then((result) => {
    return result.json();
  })
  .then((results2) => {
    results2.users.forEach((item) => {
      //lista.innerHTML += `<li>${item.firstName} ${item.lastName}</li>`;
      fila.innerHTML += `<div class="col">
      <div class="card" style="width: 18rem;">
          <img src='${item.image}' class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">${item.firstName}</h5>
            <p class="card-text">${item.address.city}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
  </div>`;
    });
    //console.log(results2);
  })
  .catch();

let usuario = new Usuario("Borja", "Martin", 123123);
console.log(JSON.stringify(usuario));
// let usuarioParse = JSON.parse(usuario);
console.log(usuarioParse);

/* usuarios
  .find((element) => {
    return element.carnet && element.proyectos.length > 0;
  })
  .proyectos.forEach((item) => console.log(item.nombre)); */

/* usuarios.forEach((element) => {
  if (element.nombre == "Borja") {
    element.proyectos.forEach((item) => {
      console.log(item.nombre);
      console.log(item.presupuesto);
    });
  }
}); */

/* usuarios.forEach((item) => {
  console.log(item.nombre);
  item.conocimientos.forEach((item) => {
    console.log(item);
  });
}); */

/* console.log(objeto.nombre);
objeto.conocimientos.forEach((item) => {
  console.log(item);
});
 */
