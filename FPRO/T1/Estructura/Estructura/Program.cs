//NAMESPACE
// CLASES 
// METODOS
// VARIABLES

// CLASES 
// METODOS
// VARIABLES

// CLASES 
// METODOS
// VARIABLES

// pubic class entrada{ main }
/*Console.Write("Por favor introduce tu nombre");
string? nombre = Console.ReadLine(); // null - ""
Console.Write("Por favor introduce tu edad");
// pasar de un tipo a otro
// casting -> cuando son tipos que uno entra dentro de otro
// parseo -> cuando son tipos incompatibles de primera Integer.parseInt(XXX)
int edad = int.Parse(Console.ReadLine());
// String.format
Console.WriteLine("Hola mi nombre es {0} y tengo {1} años", nombre, edad);
// NULL SAFETY
Console.WriteLine("Mi nombre tiene {0} letras", nombre?.Length);
// simples - complejas
// ambito - clase - bloque*/
namespace tema1
{
    class Program
    {
        // variables
        // metodos
        // constructores
        // como se escribe un metodo -> en C# los metodos se escriben en mayusculas
        // public static void main (String[] args){}
        // acceso publico: public
        // acceso directo -> wl metodo pertenece a la clase, no al objeto
        // tipo de retorno -> sin retorno
        // argumentos -> lo que necesita el metodo para funcionar
        static void Main(string[] args)
        {
            Console.WriteLine("Primera ejecucion en C# sobre una clase");
            // quiero hacer una suma de dos operandos
            Console.WriteLine("Por favor introduce el primer operando");
            int operando1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Por favor introduce el segundo operando");
            int operando2 = int.Parse(Console.ReadLine());
            MetodoDividir(operando1, operando2);
            MetodoDividir(6, 2);
            MetodoDividir(8, 4);
            MetodoDividir(18, 9);
            MetodoMultiplicar(6, 9);
        }

        // numero1 y numero2 -> los argumentos solo son referencias
        static void MetodoDividir(int numero1, int numero2)
        {
            // double / int -> int
            double division = (double)numero1 / numero2;
            Console.WriteLine("La division entre {0} / {1} es {2}", numero1, numero2, division);
        }

        static void MetodoMultiplicar(int n1, int n2)
        {
            double multiplicacion = n1 * n2;
            Console.WriteLine("La multiplicacion entre {0} * {1} es {2}", n1, n2, multiplicacion);
        }
    }
}

