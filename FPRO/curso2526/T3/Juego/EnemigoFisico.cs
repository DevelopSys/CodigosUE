internal class EnemigoFisico : Enemigo
{

    public EnemigoFisico() { }
    public EnemigoFisico(string nombre) : base(nombre)
    {
        this.listaArmas.Add("Machete");
        this.nivelAtaque *= 1.20;
        this.nivelDefensa *= 0.80;

    }
    public EnemigoFisico(string nombre, int nivelAtaque, int nivelDefensa)
    : base(nombre, nivelAtaque, nivelDefensa)
    {
        this.listaArmas.Add("Machete");
        this.nivelAtaque *= 1.20;
        this.nivelDefensa *= 0.80;
    }
    public override void Atacar(PersonajeBase personaje)
    {

    }
}