import React from "react";

const ComponenteCompra = ({ carrito }) => {
  return (
    <div>
      <h1>Lista de los productos en carrito</h1>
      <ul>
        {carrito.map((producto) => (
          <li key={producto.id}>{producto.nombre}</li>
        ))}
      </ul>
    </div>
  );
};

export default ComponenteCompra;
