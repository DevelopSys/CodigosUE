using System.Reflection.PortableExecutable;

public class FicherosController
{
    // todas las funcionalidades de los ficheros
    public void InformacionFichero(string path)
    {
        Console.WriteLine("Obteinendo informacion del fichero cuyo path es " + path);
        if (File.Exists(path))
        {
            Console.WriteLine("El fichero existe en la ruta indicada");
            using FileStream fs = File.Open(path, FileMode.Open, FileAccess.ReadWrite);
            Console.WriteLine("El fichero es de lecturas? " + fs.CanRead);
            Console.WriteLine("El fichero es de escritura? " + fs.CanWrite);
            Console.WriteLine("El fichero es de tamaño? " + fs.Length);
        }
        else
        {
            Console.WriteLine("El fichero no existe en la ruta");
            FileStream fs = File.Create(path);
            Console.WriteLine("Fichero creado correctamente");

        }

    }
    public void LecturaFichero(string path)
    {
        // TODO explicar el todo
        StreamReader? reader = null;
        reader = File.OpenText(path);
        string? linea = null;

        while ((linea = reader.ReadLine()) != null)
        {
            Console.WriteLine(linea);
        }

        /* int codigo = -1;

        while ((codigo = reader.Read()) != -1)
        {
            Console.Write((char)codigo);
        } */

    }
    public void EscrituraFichero(string path)
    {
        StreamWriter? writer = null;
        writer = File.CreateText(path);


        writer.WriteLine("Esta linea la estoy escribiendo desde el programa");
        writer.Close();

    }
}