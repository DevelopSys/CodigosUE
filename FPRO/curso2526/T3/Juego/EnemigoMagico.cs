public class EnemigoMagico : Enemigo, Curable
{
    public EnemigoMagico() { }
    public EnemigoMagico(string nombre) : base(nombre)
    {
        this.nivelAtaque *= 0.80;
        this.nivelDefensa *= 1.20;
    }

    public EnemigoMagico(string nombre, int nivelAtaque, int nivelDefensa)
    : base(nombre, nivelAtaque, nivelDefensa)
    {
        this.nivelAtaque *= 0.80;
        this.nivelDefensa *= 1.20;
    }
    public override void Atacar(PersonajeBase personaje)
    {

    }

    public void Curar(int valor)
    {
        throw new NotImplementedException();
    }

    // MostrarDatos
}