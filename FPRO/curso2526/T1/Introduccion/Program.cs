using System.Reflection;

public class Ejemplo
{
    /* Los metodos se escriben con mayuscula la primera */
    public static void Main(string[] args)
    {
        // System.out.println()
        // System.out.printf()
        // Console.WriteLine("")      
        // Scanner sc = new Scanner(System.in) 
        // sc.readInt
        Console.WriteLine("Primer ejemplo en C#");
        // string, int, double, float, bool, char
        string nombre = "Borja";
        int edad = 41;
        double altura = 1.74;
        bool experiencia = true;
        // Console.WriteLine("Mi nombre es " + nombre + ", tengo " + edad + " años y mido " + altura + " cm");
        Console.WriteLine("Por favor, introduce tu nombre");
        nombre = Console.ReadLine();
        Console.WriteLine("Por favor, introduce tu edad");
        edad = int.Parse(Console.ReadLine());
        Console.WriteLine("Por favor, introduce tu altura");
        altura = double.Parse(Console.ReadLine());
        Console.WriteLine($"Mi nombre es {nombre}, tengo {edad} años y mido {altura}cm");
        string? dato = null;
        Console.WriteLine("el dato tiene como long " + dato?.Length);
    }
}