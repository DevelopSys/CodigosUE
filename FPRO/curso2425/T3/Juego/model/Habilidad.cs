public class Habilidad
{

    private string? nombre; // null
    private int potenciador; // 0
    private int vida; // 0

    public Habilidad()
    {

    }
    public Habilidad(string nombre, int potenciador, int vida)
    {
        this.nombre = nombre;
        this.potenciador = potenciador;
        this.vida = vida;
    }

    public string? GetNombre()
    {
        return this.nombre;
    }

    public int GetVida()
    {
        return this.vida;
    }

    public int GetPotenciador()
    {
        return this.potenciador;
    }

    public void SetVida(int vida)
    {
        this.vida = vida;
    }

    public void SetNombre(string nombre)
    {
        this.nombre = nombre;
    }


}