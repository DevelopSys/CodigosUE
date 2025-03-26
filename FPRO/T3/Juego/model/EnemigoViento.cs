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
    public EnemigoViento(string nombre, int vida, int nivel, Perfil perfil, int fuezaViento, int cantidadViento) : base(nombre, vida, nivel, perfil)
    {
        this.cantidadViento = cantidadViento;
        this.fuezaViento = fuezaViento;
    }

    public new void mostrarDatos()
    {
        Console.WriteLine("Fuerza de viento " + this.fuezaViento);
        Console.WriteLine("Cantidad de viento " + this.cantidadViento);
        base.mostrarDatos();
    }


    public override void realizarAtaque()
    {
        Console.WriteLine("Ataque realizado con viento correctamnte");
    }
}