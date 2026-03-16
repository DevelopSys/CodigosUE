public abstract class Enemigo : PersonajeBase
{

    //public abstract void Atacar(PersonajeBase personaje);
    public List<string> listaArmas { get; set; }


    public Enemigo()
    {
        listaArmas = new List<string>();
    }

    public Enemigo(string nombre) : base(nombre)
    {
        listaArmas = new List<string>();
    }

    public Enemigo(string nombre, int nAtaque, int nDefensa) : base(nombre, nAtaque, nDefensa)
    {
        listaArmas = new List<string>();
    }

    public void AgregarArma(string arma)
    {
        this.listaArmas.Add(arma);
    }

    public void EliminarArma(string arma)
    {
        this.listaArmas.Remove(arma);
    }

    public override void MostrarDatos()
    {
        base.MostrarDatos();
        Console.WriteLine("Procedemos a imprimir la lista de armas");
        if (listaArmas.Count > 0)
        {
            foreach (var item in listaArmas)
            {
                Console.WriteLine(item);
            }
        }
        else
        {
            Console.WriteLine("Aún no tenemos ningún arma");
        }

    }






}