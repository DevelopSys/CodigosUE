/* importar la clase */

let productos = [
  new Producto(
    "Iphone",
    900,
    "Apple",
    "telefono",
    "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-iphone-13-starlight-2023?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1679072987025"
  ),
  new Producto(
    "Camiseta",
    2132,
    "JackJons",
    "ropa",
    "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-iphone-13-starlight-2023?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1679072987025"
  ),
  new Producto(
    "Pantalones",
    123,
    "Levis",
    "ropa",
    "https://anizbrand.es/wp-content/uploads/2020/09/LEVIS-DARK-INDIGO-WEB-min.jpg"
  ),
  new Producto(
    "Macbook",
    234,
    "Apple",
    "portatil",
    "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/macbook-air-space-gray-select-201810?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1664472289661"
  ),
  new Producto("Cascos", 435, "Samsung", "musica"),
  new Producto("Disco", 345, "LG", "muscia"),
  new Producto("Samsung galaxy", 756, "Samsung", "telefono"),
  new Producto("Smart TV", 56, "LG", "television"),
  new Producto("Zapatillas", 123, "Nike", "ropa"),
  new Producto("Television 65", 234, "Samsung", "television"),
];

let selectCategoria = document.querySelector("#select-categoria");
let seleccionCartas = document.querySelector("#seccion-cartas");

selectCategoria.addEventListener("change", (e) => {
  //console.log(selectCategoria.value);
  let listaFiltrada = productos.filter((item) => {
    return item.categoria == selectCategoria.value.toLocaleLowerCase();
  });

  representarResultados(listaFiltrada);
});

function representarResultados(lista) {
  seleccionCartas.innerHTML = "";
  lista.forEach((element) => {
    seleccionCartas.innerHTML += `<section class="col animate__animated animate__backInDown">
        <div class="card m-4" style="width: 18rem">
          <img src="${element.imagen}" class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">${element.nombre}</h5>
            <p class="card-text">
              ${element.marca} ${element.precio}
            </p>
            <a href="#" class="btn btn-primary">Ver detalles</a>
          </div>
        </div>
      </section>`;
  });
}

/* 
mimetodo("Hola")

public void mimetodo(String cosa){
    sout(cosa)
} 
*/

/* sacar solo los elementos que tienen como categoria ropa */
/* productos.forEach((element) => {
  if (element.categoria == "ropa") {
    console.log(element.getNombre);
  }
}); */
/* La lista de los elementos que cumplen la condicion de busqueda */
/* let busqueda = productos.filter((element) => {
  return element.categoria == "ropa";
});

console.log(busqueda);
 */
