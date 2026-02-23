public class MainJuego
{
    public static void Main(string[] args)
    {
        // PersonajeBase personaje1 = new PersonajeBase("Jugador1", 80, 70);
        // PersonajeBase personaje2 = new PersonajeBase("Jugador2", 90, 60);
        JugadorBueno personaje3 = new JugadorBueno("PersonajeBueno", 100, 60);
        // personaje3.AprenderHabilidad("Velocidad");
        // personaje3.AprenderHabilidad("Sigilo");
        // personaje3.MostrarDatos();
        personaje3.Atacar(null);



    }
}