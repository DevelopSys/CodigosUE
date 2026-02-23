public class JugadorBueno : PersonajeBase
{
    public List<string> habilidades { get; set; }
    public JugadorBueno()
    {
        habilidades = new List<string>();
    }
    public JugadorBueno(string nombre)
    : base(nombre)
    {
        habilidades = new List<string>();
    }
    public JugadorBueno(string nombre, int nivelAtaque, int nivelDefensa)
    : base(nombre, nivelAtaque, nivelDefensa)
    {
        habilidades = new List<string>();
    }

    public void AprenderHabilidad(string habilidad)
    {
        this.habilidades.Add(habilidad);
    }

    public override void Atacar(PersonajeBase personaje)
    {
        Console.WriteLine("El jugador se dispone a atacar");
        // la logica del jugador
    }

    public override void MostrarDatos()
    {
        base.MostrarDatos();
        Console.WriteLine("Las habilidades aprendidas por el jugador son: " + habilidades.Count);
        if (habilidades.Count > 0)
        {
            foreach (var item in habilidades)
            {
                Console.WriteLine($"Habilidad de {item} dominada");
            }
        }

    }
}