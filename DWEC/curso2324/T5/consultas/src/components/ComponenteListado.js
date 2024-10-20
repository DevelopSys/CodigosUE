import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const ComponenteListado = ({ carrito }) => {
  // API -> https://dummyjson.com/products

  const [producto, setProducto] = useState({});
  const [productos, setProductos] = useState([]);
  const [contador, setContador] = useState(2);
  let idParam = useParams("id1");

  useEffect(
    () => {
      consultaProducto();
    },
    // cuando se modifique lo que esta en este array, se ejecuta la consulta
    // [] -> cuando se ejecuta la consulta, se ejecuta una sola vez
    [contador]
  );

  // consulta();

  async function consulta() {
    let resultado = await fetch("https://dummyjson.com/products/1");
    let productos = await resultado.json();
    setProductos(productos.products);
    console.log("Ejecutando");
  }

  async function consultaProducto() {
    let resultado = await fetch("https://dummyjson.com/products/" + contador);
    let productoJSON = await resultado.json();
    setProducto(productoJSON);
    console.log(productoJSON);
  }

  return (
    <div>
      <h1>Listado elementos</h1>

      <div className="row">
        <button
          className="btn btn-primary col m-3"
          onClick={() => {
            setContador(contador - 1);
          }}
        >
          Anterior
        </button>
        <button
          className="btn btn-primary col m-3"
          onClick={() => {
            setContador(contador + 1);
          }}
        >
          Siguiente
        </button>
      </div>

      <p>{contador}</p>

      <div className="card">
        <img src={producto.thumbnail} class="card-img-top" alt="..." />
        <div className="card-body">
          <h5 className="card-title">{producto.title}</h5>
          <p className="card-text">{producto.description}</p>
          <p className="card-text">{producto.price}</p>
          <a
            className="btn btn-primary"
            onClick={() => {
              // modificar un estado con todos los productos
              carrito((e) => {
                return [...e, producto];
              });
            }}
          >
            Comprar
          </a>
        </div>
      </div>

      {/* <ul className="list-group">
        {productos.map((e) => (
          <li className="list-group-item" id={e.id}>
            {e.title}
          </li>
        ))}
      </ul> */}
    </div>
  );
};

export default ComponenteListado;
