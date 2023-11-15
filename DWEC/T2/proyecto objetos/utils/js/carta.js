class Carta {
  imagen;
  valor;
  representacion;

  constructor(representacion) {
    this.representacion = representacion;
    this.valor = this.getValor();
    this.imagen = "./utils/images/" + `${representaciom}.png`;
  }

  get getRepresentacion() {
    return this.representacion;
  }

  getValor() {
    // parte la representacion y quedate con los numeros y/o modifica los J K Q
    return this.valor;
  }

  set setValor(valor) {
    this.valor = valor;
  }

  mostrarDatos() {
    console.log("Representacion " + this.representacion);
  }
}

class CartaMagia extends Carta {
  valorMagico;

  constructor(representacion, valorMagico) {
    super(representacion);
    this.valorMagico = valorMagico;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log("valorMagico " + this.valorMagico);
  }
}

let cartaJSON = {
  representacion: "1C",
  imagen: "1C.png",
  valor: "1",
  mostrarDatos: function (param) {},
};

let carta = new Carta("1C", 1, "./utils/1C.png");
carta.setValor = 5;
console.log(carta.getValor);
console.log(carta.getRepresentacion);
