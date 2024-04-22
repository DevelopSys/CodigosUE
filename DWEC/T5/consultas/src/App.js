import logo from "./logo.svg";
import "./App.css";
import ComponenteListado from "./components/ComponenteListado";
import ComponenteCompra from "./components/ComponenteCompra";
import { Link, Route, Routes } from "react-router-dom";
import { ComponenteDefecto } from "./components/ComponenteDefecto";
import { useState } from "react";

function App() {
  const [carrito, setCarrito] = useState([]);

  return (
    <div classNameName="App">
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            Navbar
          </a>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link classNameName="nav-link" to="listado">
                  Listado
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="compra">
                  Compra
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="container">
        <Routes>
          <Route path="listado/:id?" element={<ComponenteListado />}></Route>
          {/* <Route
            path="listado"
            element={<ComponenteListado carrito={setCarrito} />}
          ></Route>
          <Route
            path="compra"
            element={<ComponenteCompra carrito={carrito} />}
          ></Route> */}
          <Route path="*" element={<ComponenteDefecto />}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
