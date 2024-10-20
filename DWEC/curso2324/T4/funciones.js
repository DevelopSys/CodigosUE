let usuario = [
  {
    nombre: "Borja",
    apellido: "Martin",
    edad: 40,
  },
  {
    nombre: "Juan",
    apellido: "Herrera",
    edad: 30,
  },
  {
    nombre: "Luis",
    apellido: "gomez",
    edad: 20,
  },
];

usuario.forEach(function (element, index, array) {
  console.log(element.nombre);
});

function operar(param1, param2, param3) {
  param1(param2, param3);
}

operar(function (p1, p2) {}, 4, 5);

operar(
  (p1, p2) => {
    console.log(p1 - p2);
  },
  4,
  5
);

setInterval(function () {
  let elemento = "asdasdasd";

  console.log("ejecucion1");
}, 2000);

setInterval(() => {
  console.log("ejecucion2");
}, 1000);
