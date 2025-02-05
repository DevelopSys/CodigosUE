public class Jugador
{
    // atributos
    private string? nombre; // si no le pongo la ?, obligando a tener valor
    private string? poderEspecial;
    private int nivelAtaque, nivelDefensa, nivelVida;
    // constructores -> 1 - por defecto -> NUNCA!! tienen retorno -> porque por defecto retorna el objeto creado 
    public Jugador() { }
    public Jugador(string nombre)
    {
        this.nombre = nombre;
        this.nivelVida = 100;
    }
    public Jugador(string nombre, string poder)
    {
        this.nombre = nombre;
        this.poderEspecial = poder;
        this.nivelVida = 100;
    }

    public Jugador(string nombre, int nivelAtaque, int nivelDefensa)
    {
        this.nombre = nombre;
        this.nivelDefensa = nivelDefensa;
        this.nivelAtaque = nivelAtaque;
        this.nivelVida = 100;
    }

    // metodos


    // setter -> metodo que establece, cambia, modifica un dato
    public void setPoder(string poder)
    {
        this.poderEspecial = poder;
    }

    public string getPoder()
    {
        return this.poderEspecial;
    }

    public void setDefensa(int defensa)
    {
        this.nivelDefensa = defensa;
    }

    public int getAtaque()
    {
        return this.nivelAtaque;
    }
    public void setAtaque(int ataque)
    {
        this.nivelAtaque = ataque;
    }

}