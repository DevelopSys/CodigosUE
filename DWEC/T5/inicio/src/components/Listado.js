import React from "react";

const Listado = ({ lista }) => {
  // usuarios

  return (
    <div>
      <h2>Listado</h2>
      <ul className="list-group">
        {lista.map((item, index) => {
          return <li key={index}> {item.nombre} </li>;
        })}
      </ul>
    </div>
  );
};

export default Listado;
