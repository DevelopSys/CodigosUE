// listas estaticas que no pueden alterer su tamaño -> en js no
const lista = [];
// Object.freeze(lista);
// lista = [];

// añadir
lista.push("Borja", "Juan", "Maria", "Celia");
lista.unshift("Claudia", "Marta", "Marcos");
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

// public void nombre(param, param){}

// function nombre(param1, param2) {}
// let var = (p1,p2)=>{ cuerpo }
