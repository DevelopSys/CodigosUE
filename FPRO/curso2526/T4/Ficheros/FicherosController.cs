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

    public void ExportarUsuarios(string path)

    {
        Alumno[] alumnos = new Alumno[]
        {
            new Alumno("Borja","Martin",8),
            new Alumno("Maria","Jimenez",9),
            new Alumno("Jorge","Perez",5),
            new Alumno("Juan","Gomez",10),
            new Alumno("Lucia","Lopez",6),
        };


        StreamWriter? writer = null;
        try
        {
            writer = File.CreateText(path);
            writer.WriteLine("nombre, apellido, nota");
            foreach (var alumno in alumnos)
            {
                writer.WriteLine(alumno.FormatCSV());
            }

        }
        catch (Exception ex)
        {
            Console.WriteLine("Error en la escritura del fichero");
        }
        finally
        {
            if (writer != null)
            {
                writer.Close();
            }
        }
    }

    public void ImportarUsuarios(string path)
    {
        StreamReader? reader = null;
        try
        {
            double media = 0.0;
            int contador = 0;
            reader = File.OpenText(path);
            string? linea = reader.ReadLine();
            Console.WriteLine(linea);
            while ((linea = reader.ReadLine()) != null)
            {
                string[] datos = linea.Split(",");
                Alumno alumno = new Alumno(datos[0], datos[1], int.Parse(datos[2]));
                media += alumno.nota;
                contador++;
            }

            Console.WriteLine("La media de todos los alumnos es de " + media / contador);

        }
        catch (Exception e)
        {
            Console.WriteLine("Error en la lectura del fichero");
        }
        finally
        {
            if (reader != null)
            {
                reader.Close();
            }
        }
    }
}