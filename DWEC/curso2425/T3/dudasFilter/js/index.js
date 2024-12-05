let productos = [
  new producto("Camiseta", 100, "ropa"),
  new producto("Pantalon", 200, "ropa"),
  new producto("Movil", 100, "tecnologia"),
  new producto("Tablet", 100, "tecnologia"),
  new producto("Bebida", 100, "alimentos"),
  new producto("Comida", 100, "alimentos"),
  new producto("Botella", 100, "cocina"),
];

let select = document.querySelector("#select-tipo");
let divProductos = document.querySelector("#div-productos");
let botonAnadir = document.querySelector("#boton-anadir");

representarProductos(productos);
select.addEventListener("change", (e) => {
  let tipo = select.value; // ropa, alimentos, tecnologia, todos
  let listaFiltrada = [];

  if (tipo != "todos") {
    listaFiltrada = productos.filter((item) => item.categoria == tipo);
  } else {
    listaFiltrada = productos;
  }

  saltarDialogo(listaFiltrada.length);
  representarProductos(listaFiltrada);
  console.log("EL resultado del filtro es");
  console.log(listaFiltrada);
});

botonAnadir.addEventListener("click", (e) => {
  let nodo = document.createElement("p");
  nodo.className = "animate__animated animate__bounce";
  nodo.textContent = "Ejemplo de nodo añadido con append";
  divProductos.append(nodo);
});

function representarProductos(productos) {
  divProductos.innerHTML = "";
  productos.forEach((item) => {
    let imagen = "";
    switch (item.categoria) {
      case "ropa":
        imagen =
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3R4Os2OPTRBjMlPQUeLu5BUE6h6bvQi7TTg&s";
        break;
      case "alimentos":
        imagen =
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAImh5S75ab5kdj2GmHUnMTOXZ5vMYXXi3ww&s";

        break;
      case "tecnologia":
        imagen =
          "https://neosystems.es/wp-content/uploads/2021/03/foto-tecno.jpeg";

        break;
      default:
        imagen =
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHmuxgLNTRF42x-SjOnu8msU6-DQ-GBcehOA&s";
        break;
    }

    divProductos.innerHTML += `
    <div class="col">
    <div class="card">
      <img src="${imagen}" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">${item.nombre}</h5>
        <p class="card-text">${item.precio}</p>
      </div>
    </div>
  </div>
    `;
  });
}

function saltarDialogo(numero) {
  console.log("dialogo");

  let icono = "success";
  if (numero == 0) {
    icono = "warning";
  }
  Swal.fire({
    title: "Productos",
    text: `La candidad de productos encontrada es de ${numero}`,
    icon: icono,
  });
}
/* 
p1 p2 p3 p4 p5 p6 p7
p1 p4 p6
*/
