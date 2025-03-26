public record Perfil(string nombre, double nivelDanio, double nivelDefensa)
{
    public static readonly Perfil jefe = new Perfil("Jefe", 5, 0.1);
    public static readonly Perfil causal = new Perfil("Casual", 1, 0);
    public static readonly Perfil complejo = new Perfil("Complejo", 2, 0.5);
}