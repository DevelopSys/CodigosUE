public abstract class PersonajeBase
{

    public string nombre { get; set; }
    public double nivelAtaque { get; set; }
    public double nivelDefensa { get; set; }
    public int vida { get; set; }

    // constructor vacio ()
    public PersonajeBase()
    { }
    public PersonajeBase(string nombre, int nivelAtaque, int nivelDefensa)
    {
        this.nombre = nombre;
        this.vida = 100;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
    }

    public PersonajeBase(string nombre)
    {
        this.nombre = nombre;
        this.vida = 100;
        this.nivelAtaque = new Random().Next(100);
        this.nivelDefensa = new Random().Next(100); ;
    }


    // todos los personajes deben poder mostrar sus datos
    public virtual void MostrarDatos()
    {
        Console.WriteLine($"Nombre {nombre}\nNivel ataque {nivelAtaque}\nNivel defensa {nivelDefensa}\nVida {vida}");
    }

    // los personajes -> jugadores quitan un % aleatorio a los enemigos
    // los enemigos -> quitan un % de vida dependiendo de su nivel de vida
    public abstract void Atacar(PersonajeBase personaje);

}