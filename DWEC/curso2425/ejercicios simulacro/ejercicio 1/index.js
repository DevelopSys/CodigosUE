let boton1 = document.querySelector("#btn1");
let boton2 = document.querySelector("#btn2");
let input = document.querySelector("#texto-calculadora");
let botonC = document.querySelector("#btnC");
let botonIgual = document.querySelector("#btnIgual");
let lista = document.querySelector("#lista");

let operando1 = 0;
let operando2 = 0;
let operando = false;
let operacion = 0; // 0 = suma, 1 = resta, 2 = multiplicacion, 3 = division

botonIgual.addEventListener("click", () => {
  if (operando) {
    operando2 = Number(input.value);
    let resultado = 0;
    switch (operacion) {
      case 0:
        resultado = operando1 + operando2;
        break;
      case 1:
        resultado = operando1 - operando2;
        break;
      case 2:
        resultado = operando1 * operando2;
        break;
      case 3:
        resultado = operando1 / operando2;
        break;
    }

    input.value = resultado;
    vaciarTexto();
    operando = false;
    operando1 = 0;
    operando2 = 0;
    lista.innerHTML += `<li class="list-group-item">${resultado}</li>`;
  }
});

botonC.addEventListener("click", (e) => {
  vaciarTexto();
});

boton1.addEventListener("click", (e) => {
  input.value += "1";
});
boton2.addEventListener("click", (e) => {
  input.value += "2";
});

function ponerNumero(numero) {
  input.value += numero;
}

function asignarOperando(tipo) {
  if (!operando) {
    operacion = tipo;
    operando1 = Number(input.value);
    vaciarTexto();
    operando = true;
  } else {
    /* switch con el tipo de operacion */
  }
}

function vaciarTexto() {
  input.value = "";
}
