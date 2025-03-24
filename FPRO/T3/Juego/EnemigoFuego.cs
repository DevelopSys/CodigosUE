class EnemigoFuego : Enemigo, Mortal
{
    // no hay nada -> el vacio
    // un elemento hereda todos los attributos y metodos de su padre (excepto los privados
    // y los constructores, a nos er que estos sean escritos)
    private int nivelFuego { get; set; }
    private string poderEspecial { get; set; }

    // nombre, nivel, vida
    public EnemigoFuego()
    {

    }
    public EnemigoFuego(string nombre, int vida, int nivel, int nivelFuego, string poderEspecial) : base(nombre, vida, nivel)
    {
        this.nivelFuego = nivelFuego;
        this.poderEspecial = poderEspecial;
    }

    public new void mostrarDatos()
    {
        Console.WriteLine("Nivel fuego " + this.nivelFuego);
        Console.WriteLine("Poder especial " + this.poderEspecial);
        base.mostrarDatos();
    }

    public void realizarSanacion()
    {
        Console.WriteLine("El enemigo de fuego procede a curarse");
    }

    public override void realizarAtaque()
    {
        Console.WriteLine("Ataque realizado con fuego correctamnte");
    }

    public void realizarAtaqueMortal1()
    {
        Console.WriteLine("Ataque mortal 1 de fuego en proceso");
    }

    public void realizarAtaqueMortal2()
    {
        Console.WriteLine("Ataque mortal 1 de agua en proceso");
    }
}