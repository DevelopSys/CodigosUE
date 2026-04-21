import { NavLink, Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./components/Home";
import DetailProps from "./components/DetailProps";
import Form from "./components/Form";

function App() {
  return (
    <div className="container">
      <nav className="mb-4">
        <NavLink to={"/"} className={"btn btn-primary me-3"}>
          Home
        </NavLink>
        <NavLink to={"/form"} className={"btn btn-primary me-3"}>
          Formulario
        </NavLink>
        <NavLink to={"/detailProps"} className={"btn btn-primary "}>
          Detalle props
        </NavLink>
      </nav>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/form" element={<Form />}></Route>
        <Route path="/detailProps" element={<DetailProps />}></Route>
      </Routes>
    </div>
  );
}

export default App;
