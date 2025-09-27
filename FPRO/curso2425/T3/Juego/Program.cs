using System.Collections;

public class Program
{
    public static void Main(string[] args)
    {
        /* Console.WriteLine("Bienvenido al juego de fundamentos de la UE");
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
        jugadorPro.ListarActividades(); */
        /* Jugador jugadorPobre = new Jugador("Celia");
        jugadorPobre.AdquirirHabilidad(lista[1]);
        jugadorPobre.ListarActividades(); */
        /* jugadorBase.AdquirirHabilidad(lista[0]);
        jugadorPro.PerderHabilidades();
        jugadorBase.ListarActividades(); */
        // habilidades 4
        // Console.WriteLine("El poder especial del jugador es " + jugador1.getPoder()?.Equals("cosa"));
        // Enemigo enemigo = new Enemigo("Enemigo1", 100, 150);

        /*
                // Enemigo, EnemigoAgua
                EnemigoAgua enemigoAgua = new EnemigoAgua("Enemigo1", 100, "tornado");
                // Enemigo, EnemigoFuego
                EnemigoFuego enemigoFuego = new EnemigoFuego("Enemigo2", 100, 40, 10, "Quemadura");
                // Enemigo, EnemigoViento
                EnemigoViento enemigoViento = new EnemigoViento("Enemigo3", 100, 90, 1000, 2);
                // ((Mortal)enemigoViento).realizarAtaqueMortal1();


                List<Enemigo> listaEnemigos = new List<Enemigo>();
                listaEnemigos.Add(enemigoAgua);
                listaEnemigos.Add(enemigoFuego);
                listaEnemigos.Add(enemigoViento);

                foreach (var item in listaEnemigos)
                {
                    // si es enemigo fuego -> instanceOf
                    if (item.GetType() == typeof(EnemigoFuego))
                    {
                        ((EnemigoFuego)item).realizarSanacion();
                    }
                    else if (item.GetType() == typeof(EnemigoAgua))
                    {
                        ((EnemigoAgua)item).rellenarAgua();
                    }

                    item.mostrarDatos();

                }*/

        Jugador jugador = new Jugador("Borja", 100, 78, Tipo.constructor);
        // jugador.MostrarDatos();
        EnemigoAgua enemigoAgua = new EnemigoAgua("Enemigo1", 100, 40, Perfil.complejo, 10, "Tornado");
        EnemigoViento enemigoViento = new EnemigoViento("Enemigo2", 100, 40, Perfil.causal, 10, 2);
        EnemigoFuego enemigoFuego1 = new EnemigoFuego("Enemigo3", 100, 40, Perfil.jefe, 10, "Quemadura");
        EnemigoFuego enemigoFuego2 = new EnemigoFuego("Enemigo3", 100, 40, Perfil.causal, 10, "Quemadura");

        //enemigoFuego2.mostrarDatos();
        jugador.Atacar(enemigoFuego1);

    }
}