import Home from "./pages/Home";

function App() {
  return (
    <>
      <div className="container m-4">
        <React.StrictMode>
          <BrowserRouter>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/detalle/:id" element={<DetalleUsuario />} />
            </Routes>
          </BrowserRouter>
        </React.StrictMode>
      </div>
    </>
  );
}

export default App;
