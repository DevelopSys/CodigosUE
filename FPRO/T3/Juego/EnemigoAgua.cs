class EnemigoAgua : Enemigo
{
    // no hay nada -> el vacio
    // un elemento hereda todos los attributos y metodos de su padre (excepto los privados
    // y los constructores, a nos er que estos sean escritos)
    public int nivelAgua { get; set; }
    public string poderAgua { get; set; }

    // nombre, nivel, vida
    public EnemigoAgua(string nombre, int vida, int nivel, int nivelAgua, string poderAgua) : base(nombre, vida, nivel)
    {
        this.nivelAgua = nivelAgua;
        this.poderAgua = poderAgua;
    }

    public EnemigoAgua(string nombre, int nivelAgua, string poderAgua) : base(nombre)
    {
        this.nivelAgua = nivelAgua;
        this.poderAgua = poderAgua;
    }

    public void mostrarDatos()
    {
        Console.WriteLine("El nivelAgua de agua del enemigo es " + nivelAgua);
        Console.WriteLine("El poder de agua del enemigo es " + poderAgua);
        base.mostrarDatos();
    }

    public override void realizarAtaque()
    {
        Console.WriteLine("El enemigo ataca con un " + poderAgua);
    }
}