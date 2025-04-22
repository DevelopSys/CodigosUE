"use client";
import { useState } from "react";
import { Usuario } from "../models/usuario";

export default function Formulario() {
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [correo, setCorreo] = useState("");
  const [usuarios, setUsuarios] = useState<Usuario[]>([]);

  function limpiarFormulario() {
    setNombre("");
    setApellido("");
    setCorreo("");
  }

  function anadirUsuarios() {
    // captura la variable lista, quedate con lo que hay en la lista y anade el nuevo usuario
    // usuarios.push(usuario);
    setUsuarios([...usuarios, { nombre, apellido, correo }]);
  }

  return (
    <div>
      <h2>Formulario APP</h2>
      <input
        value={nombre}
        type="text"
        placeholder="Introduce nombre"
        className="form-control mb-3"
        onChange={(e) => {
          setNombre(e.target.value);
        }}
      />
      <input
        value={apellido}
        type="text"
        placeholder="Introduce apellido"
        className="form-control mb-3"
        onChange={(e) => {
          setApellido(e.target.value);
        }}
      />
      <input
        value={correo}
        type="text"
        placeholder="Introduce correo"
        className="form-control mb-3"
        onChange={(e) => {
          setCorreo(e.target.value);
        }}
      />
      <button
        className="btn btn-primary mb-3"
        onClick={() => {
          // se añade a la lista
          anadirUsuarios();
          // se limpia el formulario
          limpiarFormulario();
        }}
      >
        Guardar
      </button>
      <ul className="list-group">
        {/* repetir tantos li como elementos tenga en un array de usuarios */}
        {usuarios.map((item, index) => {
          return (
            <li key={index} className="list-group-item">
              {item.nombre} {item.apellido} {item.correo}
            </li>
          );
        })}
      </ul>
    </div>
  );
}

/* 
en vez de mostrar los elementos dentro de una lista, mostrar los elementos en un conjunto de cards
si los datos del formualrio no son correctos (hay alguno vacío), sacar un alert con sweetalert
 */
