let inputNombre = document.querySelector("#nombreInput");
let inputMail = document.querySelector("#emailInput");
let inputPass = document.querySelector("#passInput");
let inputGenero = document.querySelector("#generoSelect");
let checkGuardar = document.querySelector("#checkGuardar");
let btnGuardar = document.querySelector("#btnGuardar");
let divResultados = document.querySelector("div.row.g-4");

btnGuardar.addEventListener("click", (e) => {
  // sacar toda la info del formulario
  let nombre = inputNombre.value;
  let mail = inputMail.value;
  let pass = inputPass.value;
  let genero = inputGenero.value;

  if (checkGuardar.checked) {
    if (
      nombre.length > 0 &&
      mail.length > 0 &&
      pass.length > 0 &&
      genero.length > 0
    ) {
      // guardar datos
      Swal.fire({
        title: "Existo!",
        text: "Uusario guardado correctamente!",
        icon: "success",
      });

      // se agrega un usuario a la lista ->
      /* divResultados.innerHTML += `<div class="col ">
              <div class="card animate__animated animate__fadeInDown">
                <img
                  src="https://cdn-icons-png.flaticon.com/512/5363/5363451.png"
                  class="card-img-top"
                  alt="..."
                />
                <div class="card-body">
                  <h5 class="card-title">${nombre}</h5>
                  <p class="card-text">
                    ${mail}
                  </p>
                </div>
              </div>
            </div>`; */

      agregarNodo(nombre, mail, genero);

      clearInputs();
    } else {
      Swal.fire({
        title: "Error",
        text: "Falta algun dato",
        icon: "error",
      });
    }
  }
});
function agregarNodo(nombre, email, genero) {
  let columna = document.createElement("div"); /* <div class="col"></div> */
  columna.className = "col";
  let carta = document.createElement("div");
  carta.className =
    "card animate__animated animate__fadeInDown"; /* <div class=".asdasdasdas"></div> */
  let imagen = document.createElement("img");
  imagen.className = "card-img-top";
  if (genero == 1) {
    imagen.src = "https://cdn-icons-png.flaticon.com/512/3233/3233483.png";
  } else {
    imagen.src = "https://cdn-icons-png.flaticon.com/512/3577/3577099.png";
  }
  let bodyCard = document.createElement("div");
  bodyCard.className = "card-body";
  let titulo = document.createElement("h5");
  titulo.innerText = nombre;
  bodyCard.append(titulo);

  carta.append(imagen);
  carta.append(bodyCard);
  columna.append(carta);

  divResultados.append(columna);
}
inputPass.addEventListener("keyup", (e) => {
  // cada vez que pulso quiero saber cuantos caracteres hay en el input
  console.log(e.target.value.length);
});
function clearInputs() {
  inputNombre.value = "";
  inputMail.value = "";
  inputPass.value = "";
  inputGenero.value = "Masculino";
}
