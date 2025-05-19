/* https://www.thesportsdb.com/api/v1/json/3/all_countries.php */
"use client";
import { useEffect, useState } from "react";

/*1 primero tener un elemento que guarda todos los datos Paises[] -> useState */
/*2 Rellenar el elemento definido en el punto 1 mediante una promesa (conexion con un servidor) -> useEffect */

export default function Home() {
  const [paises, setPaises] = useState([]);
  const [contador, setContador] = useState(0);
  useEffect(() => {
    // la funcion que se ejecuta cuando un elemento es modificado o cargado de nuevas

    // resolver una promesa
    let promesa = async () => {
      let resultado = await fetch(
        "https://www.thesportsdb.com/api/v1/json/3/all_countries.php"
      );
      let datos = await resultado.json();
      setPaises(datos.countries);
    };

    promesa();

    /* return () => {
      // lo que retorna la funcion se ejecuta cuando el componente se desmonta
    } */
  }, []); // el segundo argumento es un array de dependencias, si se modifica uno de los elementos del array se ejecuta la funcion

  return (
    <div>
      <h1>Lista de paises disponible</h1>
      {/* una lista de los paises que estan en el estado */}
      <ul className="list-group">
        {/* tantos li como elementos tenga el estado */}
        {paises.map((item, index) => {
          return (
            <li className="list-group-item" key={index}>
              {" "}
              {item.name_en}{" "}
            </li>
          );
        })}
      </ul>
    </div>
  );
}
