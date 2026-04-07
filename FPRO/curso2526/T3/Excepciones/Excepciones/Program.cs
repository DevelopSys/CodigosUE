class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Programa para el tratamiento de un cajero");
        // int[] numeros = { 1, 2, 3, 4 };
        // Console.WriteLine(numeros[4]); -> IndexOutofRange
        /* string? nombre = null;
        Console.WriteLine("El nombre tiene una cantirar de letras de "+nombre.Length); -> NullReference*/
        /* int operando = 0;
        int resultado = 8 / operando;
        Console.WriteLine("El resultado es " + resultado); -> DivideByZeroException */
        /*string? opcion = Console.ReadLine();
        int opcionNumero = int.Parse(opcion);
        Console.WriteLine("La opcion seleccionada es " + opcionNumero); -> FormatException*/
        Console.WriteLine("Pasamos a ver como se tratan los fallos");
        string[]? nombres = ["Borja", "Maria", "Marta", "Juan"];

        try
        {

            Console.WriteLine("Indica cual es la posicion del array que quieres investigar");
            string? posicion = Console.ReadLine();
            int posicionArray = int.Parse(posicion);
            Console.WriteLine("Perfecto, la posicion seleccionada es " + posicionArray);
            Console.WriteLine(nombres[posicionArray]);
        }
        catch (FormatException e)
        {
            Console.WriteLine("Error en la introduccion de datos");
            Console.WriteLine(e.Message);
        }
        catch (NullReferenceException e)
        {
            Console.WriteLine("La variable a la que quieres acceder es nula");

        }
        catch (IndexOutOfRangeException e)
        {
            Console.WriteLine("La posicion no es valida");
        }
        







    }
}