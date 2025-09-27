class Ejercicio1
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Ejercicio alumnos");
        List<Alumno> listaAlumnos = new List<Alumno>();

        /* FileStream -> apertura de flujo
        StreamReader -> flujo de lectura */

        FileStream fileStream = null;
        StreamReader streamReader = null;

        try
        {
            fileStream = new FileStream("/Users/borja/Documents/GitHub/CodigosUE/FPRO/EjerciciosSimulacro-Repaso/Ejercicio1/alumnos.txt", FileMode.Open);
            streamReader = new StreamReader(fileStream);

            string? linea = null;
            while ((linea = streamReader.ReadLine()) != null)
            {
                // la linea esta leida
                string[] palabras = linea.Split(",");
                Alumno alumno = new Alumno(palabras[0], int.Parse(palabras[1]));
                listaAlumnos.Add(alumno);
            }

            Console.WriteLine("El numero de alumnos leido es de " + listaAlumnos.Count);
            foreach (var item in listaAlumnos)
            {
                item.MostrarDatos();
            }

        }
        catch (System.Exception ex)
        {
            Console.WriteLine("Fallo en la lectura del programa");
        }
        finally
        {
            streamReader?.Close();
            fileStream?.Close();
        }

    }
}