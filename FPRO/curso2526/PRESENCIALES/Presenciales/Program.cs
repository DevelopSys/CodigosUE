// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

/* int radio = Console.ReadLine();
int altura = Console.ReadLine(); 
int radio = 0;
double volumen = Math.PI * Math.Pow(radio,2);
*/

// int horas = Console.ReadLine();

string nombre = Console.ReadLine();
DateTime dateTime = DateTime.Now;
string[] meses = ["E", "F", "M"];
Console.WriteLine(meses[dateTime.Month - 1]);

/* 
Buenos dias / Buenas noches / Buenas tardes Borja
Son las 9;47 de 17 de junio de 2026 y estamos en verano
 */

string saludo = "Burnos dias";
nombre = "borja";
int hora = 9;
int minutos = 10;
string mes = meses[0];
int anio = 2026;

// Console.WriteLine(saludo + " " + nombre + "Son las " + hora + ";" + minutos);
Console.WriteLine($"{saludo} {nombre} son las {hora}:{minutos}");
// "SELECT * FROM usuarios WHERE nombre  = '"+Borja"'"+ AND "+salario+">"+10000+""