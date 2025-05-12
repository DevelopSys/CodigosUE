"use client";

import React, { useEffect, useState } from "react";
import { Pais } from "../models/usuario";
import Carta from "../shared/carta";

const Consultas = () => {
  // useEffect -> primer parametro que es una funcion (realizar la peticion al API) y segundo parametro un array de dependencias

  const [paises, setPaises] = useState<Pais[]>([]);

  useEffect(() => {
    // PETICIOS A UN API ANGULAR
    // 1. en el servicio HTTPClientModule
    // 2. http.get('https://restcountries.com/v3.1/all') return un Observable
    // 3. subscribe -> el observable se convierte en una promesa
    // PETICIOES API REACT
    // 1. hago una funcion fetch() con opcion async await
    // 2. la funcion fetch() retorna una promesa
    // 3. guardo los datos de la respuesta JSON utilizando el useState
    const peticion = async () => {
      const respuesta = await fetch("https://restcountries.com/v3.1/all");
      const data = await respuesta.json();
      setPaises(data);
    };

    peticion();
  }, []);

  return (
    <div>
      <h2>Conulstas a API</h2>
      {/* mostrar todos los paises con sus cartas */}
      <div className="row row-cols-1 row-cols-md-2 g-4">
        {paises.map((pais: Pais) => {
          return <Carta key={pais.cca3} pais={pais} />;
        })}
      </div>
    </div>
  );
};

export default Consultas;
