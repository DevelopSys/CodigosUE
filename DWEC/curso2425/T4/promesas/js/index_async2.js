let boton = document.querySelector("#botonRecuperar");

boton.addEventListener("click", (e) => {
  let dato = JSON.parse(localStorage.getItem("productosCompra"));
  console.log(dato);
});

// obtenerProductos(url);
// obtenerUsuarios("https://dummyjson.com/users");
