import React from "react";
import { PropsPais } from "../models/usuario";

const Carta = (data: PropsPais) => {
  // useState -> hook de react que permite guardar el estado de un componente
  // quiero cambiar el estado de la variable pais?

  const { pais } = data; // destructuracion de objetos data {pais: pais}

  return (
    <div className="col" key={pais.ccn3}>
      <div className="card">
        <img src={pais.flags.png} className="card-img-top" alt="..."></img>
        <div className="card-body">
          <h5 className="card-title">{pais.name.official}</h5>
          <p className="card-text">{pais.continents}</p>
        </div>
      </div>
    </div>
  );
};

export default Carta;
