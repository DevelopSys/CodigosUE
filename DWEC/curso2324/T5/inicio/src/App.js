import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import Listado from "./components/Listado";

function App() {
  /* JSX */

  // estado
  // let contador = 0;
  // hook useState -> variable meotodoModVariable

  const [contador, setContador] = useState(6);
  const [valorInput, setValorInput] = useState(0);
  const [usuario, setUsuario] = useState({});
  // { nombre: "Borja", apellido: "Martin", edad: 40}
  const [usuarios, setUsuarios] = useState([]);

  let eventInputHandler = (e) => {
    setUsuario((element) => {
      return { ...element, [e.target.id]: e.target.value };
    });
  };

  return (
    <div className="App">
      <h1>Primer proyecto de REACT {contador}</h1>
      <button
        onClick={() => {
          setContador(contador + 1);
          /*contador++;
          console.log(contador);*/
        }}
      >
        Incrementar
      </button>
      <button
        onClick={() => {
          //console.log("Boton pulsado");
          setContador(contador - 1);
          console.log(contador);
        }}
      >
        Decrementar
      </button>
      <input
        type="number"
        placeholder="Introduce valor a resetear"
        onChange={(e) => {
          setValorInput(Number(e.target.value));
        }}
      />
      <button
        onClick={() => {
          //console.log("Boton pulsado");
          setContador(valorInput);
          //console.log(valorInput);
        }}
      >
        Resetear
      </button>
      <div className="row mt-3">
        <div className="col">
          <input
            id="nombre"
            onChange={(e) => {
              // {nombre: e.target.vale  y mantener el objeto}
              eventInputHandler(e);
            }}
            placeholder="Introduce nombre"
            className="form-control"
          ></input>
          <input
            id="apellido"
            onChange={(e) => {
              eventInputHandler(e);
            }}
            placeholder="Introduce apellido"
            className="form-control"
          ></input>
          <input
            id="edad"
            onChange={(e) => {
              eventInputHandler(e);
            }}
            placeholder="Introduce edad"
            type="number"
            className="form-control"
          ></input>
          <button
            className="btn btn-primary"
            onClick={(e) => {
              // [] -> lo qua ya tenia y  {los tres inputs}
              setUsuarios((element) => {
                // retorna lo que vas a poner como valor dentro de usuarios
                // donde element el valor que previamente tengo en usuarios
                return [...element, usuario];
              });

              setUsuario({ nombre: "", apellido: "", edad: "" });
            }}
          >
            Enviar a la lista
          </button>
        </div>
        <div className="col">
          <h2>Listado de usuarios</h2>
          <ul>
            {usuarios.map((item, index) => {
              return <li key={index}> {item.nombre} </li>;
            })}
          </ul>
          <Listado lista={usuarios} />
        </div>
      </div>
    </div>
  );
}

export default App;
