class carta {
  // atributo (private, public, protected)
  valor;
  imagen;
  constructor(representacion) {
    this.imagen = `./${representacion}.png`;
    this.valor = representacion.substring(0, representacion.length - 1);
    // KC -> 10
    // 9C -> 9
    if (this.valor == "J" || this.valor == "K" || this.valor == "Q") {
      this.valor = 10;
    } else {
      this.valor = Number(this.valor);
    }
  }
}
