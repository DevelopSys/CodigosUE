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
            /*Console.WriteLine("Primera ejecucion en C# sobre una clase");
            // quiero hacer una suma de dos operandos
            Console.WriteLine("Por favor introduce el primer operando");
            int operando1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Por favor introduce el segundo operando");
            int operando2 = int.Parse(Console.ReadLine());
            MetodoDividir(operando1, operando2);
            MetodoDividir(6, 2);
            MetodoDividir(8, 4);
            MetodoDividir(18, 9);
            MetodoMultiplicar(6, 9);*/
            // SELECCION -> IF - IF ELSE - IF ELSE IF ELSE -> respuesta a la pregunta es bool
            //              SWITCH - case 1 case 2 case 3 default -> valor
            // REPETICION -> FOR -> Acciones repetitivas un nº concreto de veces
            //               WHILE -> Acceiones repetitivas de 0 a nº indeterminado de veces -> condicion bool  
            //               DO WHILE -> Acceiones repetitivas de 1 a nº indeterminado de veces -> condicion bool  
            // MetodoIF();
            // MetodoSwitch();
            // MetodoFor();
            MetodoWhile();
        }

        static void MetodoWhile()
        {
            /*int opcion = -2;
            while (opcion>0)
            {
                Console.WriteLine("Repeticion");
                opcion--;
            }*/


            int opcion = 0;
            do
            {
                Console.WriteLine("Menu fundamentos programacion");
                Console.WriteLine("1. Realizar busqueda");
                Console.WriteLine("2. Realizar lectura");
                Console.WriteLine("3. Realizar insercion");
                Console.WriteLine("4. Realizar eliminacion");
                Console.WriteLine("5. Salida");
                opcion = int.Parse(Console.ReadLine());

                // 1
                switch (opcion)
                {
                    case 1:
                        Console.WriteLine("Buscando");
                        break;
                    case 2:
                        Console.WriteLine("Leyendo");
                        break;
                    case 3:
                        Console.WriteLine("Insertando");
                        break;
                    case 4:
                        Console.WriteLine("Eliminado");
                        break;
                    case 5:
                        Console.WriteLine("Saliendo");
                        break;
                    default:
                        Console.WriteLine("Sin contemplar");
                        break;

                }

            } while (opcion != 5);


        }

        static void MetodoFor()
        {
            // [0,9]
            // 0,1,2,3,4,5,6,7,8,9
            // 9,8,7,6,5,4,3,2,1,0
            //int lado = LeerDato();
            int lado = 9;
            // encargado de las filas
            for (int i = 0; i < lado; i++)
            {
                // encargado de las filas
                for (int j = 0; j < lado; j++)
                {
                    if (i == 0 || i == lado - 1)
                    {
                        Console.Write(" * ");
                    }
                    else
                    {
                        if (j == 0 || j == lado - 1)
                        {
                            Console.Write(" * ");
                        }
                        else
                        {
                            Console.Write("   ");
                        }
                    }
                }
                Console.WriteLine();
            }
            // pedirle al usuario el lado de un cuadrado -> 5
            /*
            * * * * *
            *       *
            *       *
            *       *
            * * * * *
            */
        }
        static void MetodoSwitch()
        {
            string caso = "lectura";
            switch (caso)
            {
                case "lectura":
                    Console.WriteLine("Vas a leer");
                    bool sistemaPreparado = true;
                    if (sistemaPreparado)
                    {
                        LeerDato();
                    }

                    break;
                case "escritura":
                    Console.WriteLine("Vas a escribir");
                    break;
                case "exportacion":
                    Console.WriteLine("Vas a exportar");
                    break;
                default:
                    Console.WriteLine("No se contempla");
                    break;
            }
        }

        static int LeerDato()
        {
            Console.WriteLine("Por favor introduce un dato");
            int numero = Console.Read();
            return numero;
        }
        static void MetodoIF()
        {
            int numero = 14;
            if (numero > 0)
            {
                Console.WriteLine("El numero es positivo");
            }
            if (numero < 10)
            {
                Console.WriteLine("El numero tiene un digito");
            }
            if (numero > 0 && numero < 10)
            {
                Console.WriteLine("El numero esta entre 0 y 9");
            }
            else
            {
                Console.WriteLine("No es un numero menor que 10");
            }
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

