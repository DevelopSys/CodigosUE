public class Alumno
{
    public string? nombre { get; set; }
    public string? apellido { get; set; }
    public int nota { get; set; }

    public Alumno(string nombre, string apellido, int nota)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public Alumno()
    {

    }

    public string FormatCSV()
    {
        return string.Format("{0},{1},{2}", nombre, apellido, nota);
    }

}