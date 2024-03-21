import logo from "./logo.svg";
import "./App.css";

function App() {
  /* JSX */

  // estado
  let contador = 0;
  return (
    <div className="App">
      <h1>Primer proyecto de REACT {contador}</h1>
      <button
        onClick={() => {
          //console.log("Boton pulsado");
          contador++;
          console.log(contador);
        }}
      >
        Pulsar
      </button>
    </div>
  );
}

export default App;
