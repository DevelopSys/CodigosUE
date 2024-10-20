import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import Listado from "./components/Listado";
import Carrito from "./components/Carrito";

function App() {
  /* JSX */

  // estado
  // let contador = 0;
  // hook useState -> variable meotodoModVariable

  const [productos, setProductos] = useState([]);
  const [compra, setCompra] = useState([]);

  async function lectura() {
    let resultadoJson = await fetch(`https://dummyjson.com/products`);
    let resultadoReal = await resultadoJson.json();

    setProductos(resultadoReal.products);
    setProductos(resultadoReal.products);
  }

  useEffect(() => {
    lectura();
  }, []);

  return (
    <div className="App">
      <h1>Primer proyecto de REACT </h1>
      <div className="row">
        <div className="col">
          <h2>Lista productos</h2>
          {productos.map((item) => {
            return (
              <li>
                {item.title}{" "}
                <button
                  onClick={() => {
                    setCompra((element) => {
                      return [...element, item];
                    });
                  }}
                >
                  Añadir
                </button>
              </li>
            );
          })}
        </div>
        <div className="col">
          <Carrito productos={compra}></Carrito>
        </div>
      </div>
    </div>
  );
}

export default App;
