/* crear un objeto */
/* class Producto extens Herencia implements Interfaz{

    constructor
    misMetodos
    getter / setter

}*/
class Producto {
  nombre;
  precio;
  marca;
  categoria;
  imagen;

  constructor(nombre, precio, marca, categoria, imagen) {
    this.marca = marca;
    this.categoria = categoria;
    this.nombre = nombre;
    this.precio = precio;
    this.imagen = imagen;
  }

  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Marca: ${this.marca}`);
    console.log(`Categoria: ${this.categoria}`);
    console.log(`Precio: ${this.precio}`);
  }

  get getNombre() {
    return this.nombre;
  }

  set setNombre(nombre) {
    this.nombre = nombre;
  }
}
