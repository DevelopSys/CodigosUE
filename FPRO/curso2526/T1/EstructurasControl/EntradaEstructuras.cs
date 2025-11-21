public class EntradaEstructuras
{
    public static void Main(string[] args)
    {
        string variable = "Borja";
        Console.WriteLine($"Mi nombre {variable}");
        // if -> ejecucion de bloques dependiendo de una condicion logica
        Console.WriteLine("Introduce una nota");
        /*int nota = int.Parse(Console.ReadLine());
        if (nota < 0 || nota > 10)
        {
            Console.WriteLine("Nota invalida");
        }
        else
        {
            if (nota >= 5)
            {
                Console.WriteLine("El examen está aaprobado");
            }
            else
            {
                if (nota < 3)
                {
                    Console.WriteLine("Muy mal, suspenso");

                }
                else
                {
                    Console.WriteLine("Por los pelos");
                }
            }
        }*/
        // el if ternario permite asignar un valor dependiendo de una condicion logica
        // este tipo de if me vale solo para dos opciones
        int nota = int.Parse(Console.ReadLine());
        // variable = condicion ? valor_true : valor_fasle
        string resultado = nota >= 5 ? "aprobado" : "suspenso";
        Console.WriteLine("El examen esta " + resultado + " con if ternario");
        // switch -> evalua un valor numerico / string / char
        /*
        1-4 susensos
        5-7 aprobados
        8,9 notables
        10 sobresaliente
        */
        Console.WriteLine("Ahora vamos a evaluar la nota con un switch");
        /*
        switch (nota)
        {
            case 1 or 2 or 3 or 4:
                Console.WriteLine("Suspenso");
                break;
            case 5 or 6 or 7:
                Console.WriteLine("Aprobado");
                break;
            case 8 or 9:
                Console.WriteLine("Notable");
                break;
            case 10:
                Console.WriteLine("Sobresaliente");
                break;
            default:
                Console.WriteLine("invalida");
                break;
        }
        */

        resultado = nota switch
        {
            1 or 2 or 3 or 4 => "suspenso",
            5 or 6 or 7 => "aprobado",
            8 or 9 => "notable",
            10 => "sobresaliente",
            _ => "no valida"
        };
        Console.WriteLine("La nota evaluada es " + resultado + " con switch");
        /* 
        // for -> repetia n veces (del rango indico). Utilizado para poder repetir elementos
        Console.WriteLine("Cuantos aleatorios quieres generar");
        int numeroAleatorios = int.Parse(Console.ReadLine());
        Console.WriteLine("Cual es el aleatorio mas grande");
        int maxAleatorio = int.Parse(Console.ReadLine());

        for (int i = 0; i < numeroAleatorios; i++)
        {
            int aleatorio = new Random().Next(maxAleatorio);
            Console.WriteLine($"Repeticion {i} con el aleatorio generado como {aleatorio} ");
        }
 */
        /* for (int i = 0; i < 11; i++)
        {
            Console.WriteLine($"1*{i} = {1 * i}");
            if (i == 5)
            {
                break;
            }
            Console.WriteLine("Vamos a escribir la tabla del " + i);
            for (int j = 0; j < 11; j++)
            {
                Console.WriteLine($"\t{i} * {j} = {i * j}");

            }
            if (i == 5)
            {
                break;
            }
        } */

        /* 
        while -> no asegura ejecucion 0 a n
        do while -> asegura ejecucion 1 a n
         */

        int opcion;
        do
        {
            opcion = int.Parse(Console.ReadLine());
            // pide los operandos?
            int resultadoOperacion;
            switch (opcion)
            {
                case 1:
                    resultadoOperacion = 2;
                    Console.WriteLine("Vas a realizar una suma");
                    // pide los operandos
                    break;
                case 2:
                    resultadoOperacion = 5;
                    Console.WriteLine("Vas a realizar una resta");
                    // pide los operandos
                    break;
                case 3:
                    resultadoOperacion = 5;
                    Console.WriteLine("Vas a realizar una multi");
                    // pide los operandos
                    break;
                case 4:
                    resultadoOperacion = 5;
                    Console.WriteLine("Vas a realizar una div");
                    // pide los operandos
                    break;
                default:
                resultadoOperacion=0;
                    break;
            }

            Console.WriteLine("EL valor correspondiente es " + resultadoOperacion);
        } while (opcion != 5);

    }
}