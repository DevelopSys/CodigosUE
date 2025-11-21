// listas estaticas que no pueden alterer su tamaño -> en js no
const lista = [];
// Object.freeze(lista);
// lista = [];

// añadir
lista.push("Borja", "Juan", "Maria", "Celia");
lista.unshift("Oso", "Marta", "Ana");
// lista[30] = "Cosa"
// borrar
// elimina el ultimo y lo retorna
// lista.pop()
// elimina el primer y lo retorna
// lista.shift()
/* let confirmacion = confirm("Quieres eliminar el elemento");
if (confirmacion) {
  Swal.fire(
    `Usuario con nombre ${lista.shift()} eliminaro correctamente. QUedan ${
      lista.length
    }!`
  ); // Roberto
} */

// tamaño -> length
// recorrer y mostrar
/* for (let index = 0; index < lista.length; index++) {
  console.log(lista[index]);
} */
/* 
for(String item : lista) {  }
 */

lista.forEach((item, index) => {
  // se ejecuta una vez por cada elemento de la lista (por cada iteracion)
  if (item.length > 6) {
    console.log(`Ejecutando vuelta ${index} con valor ${item}`);
  }
});

// find -> encuentra el elemento de la lista con la condicion buscada -> retorna o un null o un elemento
/* let encontrado = lista.find((item) => {
  return item.length == 10;
}); */

// filter -> encuentra los elementos de la lista con la condicion buscada -> retorna un []
let listaBuscada = lista.filter((item) => {
  return item.length == 3;
});

console.log(listaBuscada);

// console.log(encontrado);

// public void nombre(param, param){}

// function nombre(param1, param2) {}
// let var = (p1,p2)=>{ cuerpo }
