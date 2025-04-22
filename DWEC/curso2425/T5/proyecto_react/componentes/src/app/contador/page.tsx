"use client";
import React, { useState } from "react";

export default function Contador() {
  // hago lo que quiera
  // me declaro una funcion (arrow function)
  // me declaro una variable

  // useState es un hook de react que me permite crear un estado
  const [contador, setContador] = useState(9);
  const evenHandler = (e) => {
    const id = e.target.id;
    switch (id) {
      case "1":
        setContador(contador + 1);
        break;
      case "2":
        setContador(contador - 1);
        break;
      case "3":
        setContador(0);
        break;
    }
  };

  return (
    <div>
      <h2>Contador App</h2>
      <p>El valor de contador es: {contador}</p>
      <button id="1" class="btn btn-primary" onClick={evenHandler}>
        Incrementar
      </button>
      <button id="2" class="btn btn-primary" onClick={evenHandler}>
        Decrementar
      </button>
      <button id="3" class="btn btn-primary" onClick={evenHandler}>
        Resetear
      </button>
    </div>
  );
}

/* 
poner un elemento que haga de input para indicar el valor del contador que se resetea
 */
