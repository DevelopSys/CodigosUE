public class Personaje
{
    // atributos
    public string nombre { get; set; }
    public int vida { get; set; }
    public List<string> poderes { get; set; }
    public bool estaVivo { get; set; }

    public Personaje() { }
    public Personaje(string nombre, int vida)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.poderes = new List<string>();
        this.estaVivo = true;
        // this.vida = 0;
        // this.estaVivo = false
    }

    public void MostrarDatos()
    {
        Console.WriteLine($"El personaje tiene como nombre {nombre}");
        if (this.estaVivo)
        {
            Console.WriteLine($"Al personaje aun le quedan {vida} de vida");
        }
        else
        {
            Console.WriteLine("El personaje esta caput");
        }
    }

    public int Atacar()
    {
        return new Random().Next(5, 20);
    }

    public void RestarVida(int vida)
    {
        this.vida -= vida;
    }
}