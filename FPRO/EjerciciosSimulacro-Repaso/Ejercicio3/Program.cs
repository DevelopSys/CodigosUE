public class Ejercicio3
{
    public static void Main(string[] args)
    {
        List<int> listaNumeros = new List<int>();
        for (int i = 0; i < 20; i++)
        {
            int numero = new Random().Next(0, 100);
            listaNumeros.Add(numero);
            Console.WriteLine("Numero generado correctamente " + numero);
        }
        Console.WriteLine("Numero generados correctamente");

        int numeroPares = 0, numeroImpares = 0, numeroMax = listaNumeros[0], numeroMin = listaNumeros[0], suma = 0;
        listaNumeros.Sort();


        foreach (var item in listaNumeros)
        {
            if (item % 2 == 0)
            {
                // es par
                numeroPares++;
            }
            else
            {
                // es impar
                numeroImpares++;
            }

            /* if (item > numeroMax)
            {
                numeroMax = item;
            }
            if (item < numeroMin)
            {
                numeroMin = item;
            } */
            suma += item;
        }

        Console.WriteLine("Los resultados son");
        Console.WriteLine("Numero de pares " + numeroPares);
        Console.WriteLine("Numero de impares " + numeroImpares);
        Console.WriteLine("Numero de mas grande " + listaNumeros[listaNumeros.Count - 1]);
        Console.WriteLine("Numero de mas pequeño " + listaNumeros[0]);
        Console.WriteLine("suma " + suma);

    }
}