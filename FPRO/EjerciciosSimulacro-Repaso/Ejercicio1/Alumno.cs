public class Alumno
{
    private string nombre;
    private int nota;

    public Alumno()
    {

    }

    public Alumno(string nombre, int nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getNota()
    {
        return this.nota;
    }

    public string getNombre()
    {
        return this.nombre;
    }

    public void MostrarDatos()
    {
        Console.WriteLine("Los datos del usuarios son");
        Console.WriteLine("Nombre: " + nombre);
        Console.WriteLine("Nota: " + nota);
    }

}