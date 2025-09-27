using System.Collections;

public class Jugador
{
    // atributos
    private string? nombre; // si no le pongo la ?, obligando a tener valor
    private string? poderEspecial;
    private int nivelAtaque, nivelDefensa, nivelVida;
    private Tipo tipo;
    // conjunto de habilidades
    public List<Habilidad> listaHabilidades;

    // constructores -> 1 - por defecto -> NUNCA!! tienen retorno -> porque por defecto retorna el objeto creado 
    public Jugador() { }
    public Jugador(string nombre)
    {
        this.nombre = nombre;
        this.nivelVida = 100;
        this.listaHabilidades = new List<Habilidad>();
    }
    public Jugador(string nombre, string poder)
    {
        this.nombre = nombre;
        this.poderEspecial = poder;
        this.nivelVida = 100;
        this.listaHabilidades = new List<Habilidad>();
    }

    public Jugador(string nombre, int nivelAtaque, int nivelDefensa, Tipo tipo)
    {
        this.nombre = nombre;
        this.nivelDefensa = nivelDefensa;
        this.nivelAtaque = nivelAtaque;
        this.nivelVida = 100;
        this.listaHabilidades = new List<Habilidad>(); // 0 habilidades
        this.tipo = tipo;
    }

    public Jugador(string nombre, int nivelAtaque, int nivelDefensa, List<Habilidad> lista)
    {
        this.listaHabilidades = lista;
        this.nombre = nombre;
        this.nivelDefensa = nivelDefensa;
        this.nivelAtaque = nivelAtaque;
        this.nivelVida = 100;
    }

    // metodos
    public void MostrarDatos()
    {
        Console.WriteLine("Nombre: " + this.nombre);
        Console.WriteLine("Ataque: " + this.nivelAtaque);
        Console.WriteLine("Defensa: " + this.nivelDefensa);
        Console.WriteLine("Vida: " + this.nivelVida);
        Console.WriteLine("Tipo: " + this.tipo);
    }
    public void Atacar(Jugador jugador)
    {
        if (this.nivelAtaque > jugador.GetAtaque())
        {
            Console.WriteLine("Soy el campeon");
            this.listaHabilidades.AddRange(jugador.GetListaHabilidades());
            jugador.GetListaHabilidades().Clear();
        }
        else
        {

            Console.WriteLine("Me han dado una paliza");
            jugador.GetListaHabilidades().AddRange(this.listaHabilidades);
            this.listaHabilidades.Clear();
        }
    }

    public void Atacar(Enemigo enemigo)
    {
        int resultadoAtaque = 0;
        bool exito = false;
        try
        {
            resultadoAtaque = enemigo.vida / 0;
            exito = true;
        }
        catch (System.DivideByZeroException e)
        {
            Console.WriteLine("No se puede dividir por 0");
        }
        finally
        {
            if (exito)
            {
                Console.WriteLine("Ataque exitoso");
            }
            else
            {
                Console.WriteLine("Ataque fallido");
            }
            Console.WriteLine("Terminando ataque");
        }


        Console.WriteLine("El resultado del ataque es " + resultadoAtaque);
    }

    public void AdquirirHabilidad(Habilidad habilidad)
    {
        this.listaHabilidades.Add(habilidad);
    }

    public void PerderHabilidades()
    {
        this.listaHabilidades.Clear();
    }

    public void ListarActividades()
    {
        foreach (var item in listaHabilidades)
        {
            Console.WriteLine(item.GetNombre());
            Console.WriteLine(item.GetPotenciador());
            Console.WriteLine(item.GetVida());
        }
    }

    // setter -> metodo que establece, cambia, modifica un dato
    public void SetPoder(string poder)
    {
        this.poderEspecial = poder;
    }

    public List<Habilidad> GetListaHabilidades()
    {
        return this.listaHabilidades;
    }
    public string GetPoder()
    {
        return this.poderEspecial;
    }

    public void SetDefensa(int defensa)
    {
        this.nivelDefensa = defensa;
    }

    public int GetAtaque()
    {
        return this.nivelAtaque;
    }
    public void SetAtaque(int ataque)
    {
        this.nivelAtaque = ataque;
    }

}