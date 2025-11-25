class Carta {
  valor;
  imagen;
  nombre;

  constructor( nombre,imagen) {}

  getValor(){
    return "desde la pos 0 hsta la posi letra-1"
  }
}

let carta = new Carta("1C","assets/1C.png")
carta.imagen


 /* 
 .cartas{
    border
    padding
 }
    <img class="cartas" src=`${carta.imagen}}`>
 */
