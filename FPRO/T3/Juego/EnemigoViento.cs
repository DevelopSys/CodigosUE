class EnemigoViento : Enemigo
{
    // no hay nada -> el vacio
    // un elemento hereda todos los attributos y metodos de su padre (excepto los privados
    // y los constructores, a nos er que estos sean escritos)
    private int fuezaViento { get; set; }
    private int cantidadViento { get; set; }

    // nombre, nivel, vida
    public EnemigoViento()
    {

    }
    public EnemigoViento(string nombre, int vida, int nivel, int fuezaViento, int cantidadViento) : base(nombre, vida, nivel)
    {
        this.cantidadViento = cantidadViento;
        this.fuezaViento = fuezaViento;
    }

    public void mostrarDatos()
    {

        base.mostrarDatos();
    }
    public override void realizarAtaque()
    {
        Console.WriteLine("Ataque realizado con viento correctamnte");
    }
}