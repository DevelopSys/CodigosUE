import React, { useState } from "react";

const Carrito = ({ productos }) => {
  console.log(productos);

  return (
    <div>
      Carrito
      {
        <ul>
          {productos.map((item) => {
            return <li>{item.title}</li>;
          })}
        </ul>
      }
    </div>
  );
};

export default Carrito;
