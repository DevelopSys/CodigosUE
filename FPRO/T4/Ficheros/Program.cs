class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Trabajo con ficheros");
        Operaciones operaciones = new Operaciones();
        //operaciones.ObtenerInformacion("/Users/borja/Documents/GitHub/CodigosUE/FPRO/T4/Ficheros/escritura.txt");
        //operaciones.EscribirFichero("/Users/borja/Documents/GitHub/CodigosUE/FPRO/T4/Ficheros/escritura.txt");
        //operaciones.LeerFichero("/Users/borja/Documents/GitHub/CodigosUE/FPRO/T4/Ficheros/escritura.txt");
        operaciones.ExportarUsuarios("/Users/borja/Documents/GitHub/CodigosUE/FPRO/T4/Ficheros/usuarios.txt");
    }
}