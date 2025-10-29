console.log("Ejecucion desde interaccion");
let nombre = "Borja";
// muestra info al usuario
// alert(`Bienvenido ${nombre} a la primera app js`);
// pide un confirmacion al usuario
/* let respuesta = confirm("Estas seguro que quieres continuar");
if (respuesta) {
  alert("El usuario ha dicho que si, por lo tanto esta dentro del sistema");
} else {
  alert("El usuario ha dicho que no, por lo tanto esta fuera del sistema");
} */
nombre = prompt("Por favor introduce tu nombre"); // ""
if (nombre != null && nombre.length > 0) {
  Swal.fire({
    title: `${nombre}`,
    text: "Nombre introducido correctamente",
    icon: "success",
  });
} else {
  Swal.fire({
    icon: "error",
    title: "Oops...",
    text: "Por favor introduce nombre correcto!",
  });
}
