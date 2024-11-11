let baraja = [];
let palos = ["C", "T", "R", "P"];
// 1C....10111213C,1T...10111213T
for (let index = 0; index < palos.length; index++) {
  // C T R P
  for (let i = 1; i <= 13; i++) {
    switch (i) {
      case 11:
        // JC.png
        baraja.push(new carta("J" + palos[index]));
        break;
      case 12:
        baraja.push(new carta("Q" + palos[index]));
        break;
      case 13:
        baraja.push(new carta("K" + palos[index]));
        break;
      default:
        baraja.push(new carta(i + palos[index]));
        break;
    }
  }
}
baraja = _.shuffle(baraja);
// baraja = [];

// empiezo a jugar -> la banca juega hasta que tenga una cuenta de 17 o mas

let cuentaBanca = 0;

// setTimeout -> postergo la ejecucion de una accion
// setInterval -> ejecuta una accion cada X segundos
let intervalo = setInterval(() => {
  console.log("Sacando carta......");
  if (cuentaBanca < 17) {
    let carta = baraja.pop();
    cuentaBanca += carta.valor;
    console.log(carta.valor);
    console.log(carta.imagen);
    console.log(cuentaBanca);
  } else {
    // 17 -
    clearInterval(intervalo);
  }
}, 2000);

/* while (cuentaBanca < 17) {
  cuentaBanca += baraja.pop().valor;
} */

console.log(`La banca para de jugar porque tiene ${cuentaBanca}`);

// repito el proceso para el jugador
// misma logica
// la banca tiene > de 21 -> el jugador gana
// si la banca tiene <22
// comparo puntuaciones y decido ganador
