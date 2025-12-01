class Entrada
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Ejecucion de estructuras de datos");
        string[] asignaturas = new string[] { "Programacion", "Base de datos", "Sistemas", "Fundamentos" };
        // obtener uno de los elementos del array -> aleatorio
        // new Random().Next(5); // aleatorio entre 0-5
        asignaturas[3] = "Python";
        Console.WriteLine(asignaturas[3]);
        int[] notas = new int[10];
        int sumatorioNotas = 0;
        for (var i = 0; i < notas.Length; i++)
        {
            Console.Write("Por favor introduce la nota");
            notas[i] = int.Parse(Console.ReadLine());
            sumatorioNotas += notas[i];
        }

        /* int tempo = notas[0];
        for (int i = 0; i < notas.Length-1; i++)
        {
            notas[i] = notas[i+1];
        }
        notas[notas.Length-1] = tempo; */

        for (var j = 0; j < 3; j++)
        {
            int tempo = notas[notas.Length - 1];
            for (int i = notas.Length - 1; i > 0; i--)
            {
                notas[i] = notas[i - 1];
            }
            notas[0] = tempo;
        }

        Console.WriteLine("Sacando todas las notas");
        foreach (var item in notas)
        {
            Console.WriteLine(item);
        }

        // la nota media de la asignatura es = XXX
        // Console.WriteLine("La media obtenida es de " + double.Parse(sumatorioNotas.ToString()) / notas.Length);


    }
}