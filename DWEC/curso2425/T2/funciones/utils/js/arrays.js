// array -> coleccion de datos
const equipos = [
  "Barcelona",
  "Madrid",
  "Bilbao",
  "Atletico",
  "Villareal",
  "Osasuna",
];
/* equipos[4] = "Osasuna";
equipos[10] = "Villareal";
equipos[5] = "Real Sociedad"; */
equipos[1] = "R. Madrid";
console.log(equipos);

/* for (let index = 0; index < equipos.length; index++) {
  const equipo = equipos[index];
  console.log(equipo);
} */
/* for (const key in equipos) {
  console.log(key);
} */
/* for (const equipo of equipos) {
  console.log(equipo);
} */
// foreach es un FUNCION que me permite iterar -> aplicada a arrays
// con tres paremetros el elemento, el indice y lo que recorres
// element -> MAdrid
/*equipos.forEach((element, i) => {
  if (i % 2 == 0) {
    console.log(element);
  }
});*/

// añadir elementos
equipos.push("Getafe", "Rayo"); // coloca el/los elemento en el final del array
console.log(equipos.unshift("Alaves", "Las Palmas")); // coloca el/los elementos al principio

// borrar elementos
equipos.pop(); // elimina el ultimo elemento del array
console.log(`Elemento eliminado correctamente: ${equipos.shift()}`); // elimina el primer elemento del array

// filtrar elementos
// find -> retorna el primer elemento que coincida con la busqueda
// vamos a buscar un equipo que tenga al menos 7 letras
let busqueda = equipos.find((item) => {
  // retornar true cuando item cumple la condicion de busqueda
  return item.length >= 19;
});

// console.log(busqueda);

// filter -> retorna todos los elementos que coinciden con la busqueda
equipos
  .filter((item) => {
    return item.length >= 7;
  })
  .forEach((item) => {
    console.log(item);
  });
// console.log(equipos);

// CREAR UNA BARAJA DE CARTAS -> 4 PALOS (C,R,T,P) 13 (1,9,10,J-11,Q-12,K-13)
// INTENTAR MEZCLARLAS
// SACARLAS DE UNA EN UNA HASTA QUE NO TENGA NINGUNA EN LA BARAJA
// SACAR LAS CARTAS DEL PALO QUE ME PIDA EL USUARIO
// SACAR UNA CARTA y OBTENER SU VALOR 5C -> 5
// 5C - 10C
let carta = "10C";
carta.substring(0, carta.length - 1);
