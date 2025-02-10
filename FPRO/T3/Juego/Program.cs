using System.Collections;

public class main
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Bienvenido al juego de fundamentos de la UE");
        // habilidades = 0 habilidades
        List<Habilidad> lista = new List<Habilidad>();
        lista.Add(new Habilidad("Velocidad", 2, 100));
        lista.Add(new Habilidad("Fuerza", 3, 10));
        lista.Add(new Habilidad("Vision", 1, 50));
        lista.Add(new Habilidad("Sabiduria", 4, 200));
        Jugador jugadorBase = new Jugador("Borja", 69, 87);
        Jugador jugadorPro = new Jugador("BorjaH", 70, 97, lista);

        jugadorBase.Atacar(jugadorPro);
        Console.WriteLine("Habilidades del Base");
        jugadorBase.ListarActividades();

        Console.WriteLine("Habilidades del Pro");
        jugadorPro.ListarActividades();


        /* Jugador jugadorPobre = new Jugador("Celia");
        jugadorPobre.AdquirirHabilidad(lista[1]);
        jugadorPobre.ListarActividades(); */



        /* jugadorBase.AdquirirHabilidad(lista[0]);
        jugadorPro.PerderHabilidades();
        jugadorBase.ListarActividades(); */


        // habilidades 4

        // Console.WriteLine("El poder especial del jugador es " + jugador1.getPoder()?.Equals("cosa"));
    }
}