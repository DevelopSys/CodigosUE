/* int[] numeros = new int[]{1,2,3,4,6};
// numeros.Length
numeros[0] = 1;
numeros[1]; 
foreach (var item in numeros)
{
    Console.WriteLine(item);
}*/

using System.Diagnostics.CodeAnalysis;

List<int> numerosLista = new List<int>();
Console.WriteLine("La longitud de la lista es de " + numerosLista.Count);
numerosLista.Add(10); // se queda asignado en la ultima posicion -> pos 0
numerosLista.Add(22); // se queda asignado en la ultima posicion -> pos 1
numerosLista.Add(31); // se queda asignado en la ultima posicion -> pos 2
numerosLista.Add(35); // se queda asignado en la ultima posicion -> pos 2
numerosLista.Add(34); // se queda asignado en la ultima posicion -> pos 2
numerosLista.Add(38); // se queda asignado en la ultima posicion -> pos 2
// numerosLista.RemoveAt(0);
int elemento = numerosLista.ElementAt(0); //10
Console.WriteLine("Todos los elementos de lista");
for (int i = 0; i < numerosLista.Count; i++)
{
    if (numerosLista.ElementAt(i) % 2 != 0)
    {
        numerosLista.RemoveAt(i);
    }
}

// como borraria todos los elementos impares
/* foreach (var item in numerosLista)
{
    Console.WriteLine(item);
} */
// Console.WriteLine("El elemento en la primera posicion es " + elemento);
/* if (eliminado)
{
    Console.WriteLine("Elemento eliinado correctamente");
}
else
{
    Console.WriteLine("El elemento no estaba en la lista");
} */
// Console.WriteLine("La longitud de la lista es de " + numerosLista.Count);