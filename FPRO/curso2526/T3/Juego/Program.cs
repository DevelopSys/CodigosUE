public class Game
{
    /* public static void Main(string[] args)
     {
         Console.WriteLine("Bienvenido al juego de la UE");
         Personaje personaje1 = new Personaje("marco", 100);
         Personaje personaje2 = new Personaje("laura", 100);

         // quiero que los personajes luchen a muerte
         // hay tantas rondas como sea necesario.
         // cuando un personaje gane, se muestran sus datos

         int rondas = 0;
         do
         {
             rondas++;
             personaje1.RestarVida(personaje2.Atacar());
             if (personaje1.vida < 0)
                 break;
             personaje2.RestarVida(personaje1.Atacar());
             if (personaje2.vida < 0)
                 break;
         } while (personaje1.vida > 0 && personaje2.vida > 0);

         Console.WriteLine($"Los personajes han aguandado {rondas} rondas");
         Console.WriteLine("El ganador es");
         Personaje? ganador = null;
         if (personaje1.vida > 0)
         {
             ganador = personaje1;
         }
         else if (personaje2.vida > 0)
         {
             ganador = personaje2;
         }

         Console.WriteLine($"El nombre del ganador es {ganador?.nombre} ");






     }*/

    public static void Main(string[] args)
    {
        EnemigoMagico enemigoMagico = new EnemigoMagico("Mago", 100, 100);
        PersonajeBase enemigoFisico = new EnemigoFisico("Arqueto", 100, 100);
        PersonajeBase jugador = new Jugador("Jugador");

    }
}