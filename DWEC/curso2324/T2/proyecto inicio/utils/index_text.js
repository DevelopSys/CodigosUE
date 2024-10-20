let correo = "borja.martin@universidadeuropea.es";

// split
let nombre = correo.split("@")[0];
let dominio = correo.split("@")[1];
//substring
nombre = correo.substring(0, correo.indexOf("@"));
dominio = correo.substring(correo.indexOf("@") + 1); // termino en el final
console.log(nombre);
console.log(dominio);

/* for (let index = 0; index < correo.length; index++) {
  console.log(correo.charAt(index));
} */

correo.split("").forEach((element) => {
  console.log(element);
});
