let url = "https://dummyjson.com/products";
let boton = document.querySelector("#botonGuardar");
let productos;
// 1. lanzo la peticion al server
// 2. con el then analizo la respuesta
// 3. dentro de ese then la paso a json()
// 4. en otro then analizo la respuesta de la traduccion
// 5. trato la respuesta

// await -> espera. indica que a funcion donde esta aplicada es una promesa y no tengo que usar el then para obtener la respuesta
// async -> asincrono. indica a aquella funcion donde se aplica el modificador await que tiene que se asincrono

async function obtenerProductos(url) {
  let respuesta = await fetch(url);
  let json = await respuesta.json();
  productos = json.products;
}

async function obtenerUsuarios(url) {
  let respuesta = await fetch(url);
  let json = await respuesta.json();
  console.log(json.users);
}

obtenerProductos(url);

boton.addEventListener("click", (e) => {
  localStorage.setItem("productosCompra", JSON.stringify(productos));
});

// obtenerProductos(url);
// obtenerUsuarios("https://dummyjson.com/users");
