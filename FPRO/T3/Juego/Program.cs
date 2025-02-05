public class main
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Bienvenido al juego de fundamentos de la UE");
        Jugador jugador1 = new Jugador("Borja", 79, 87);

        Console.WriteLine("El poder especial del jugador es " + jugador1.getPoder()?.Equals("cosa"));
    }
}