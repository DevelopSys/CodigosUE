public class Agenda
{
    // variables
    private Dictionary<string, string> personas = new System.Collections.Generic.Dictionary<string, string>()
    {
        {"001A","Borja"},
        {"001B","Celia"},
        {"001C","Juan"},
    };

    // 000000001, ["Borja"]
    // "000000001A", "Borja"

    // C agregar datos
    public void AgregarPersona(string dni, string nommbre)
    {
        if (personas.ContainsKey(dni) == true)
        {
            Console.WriteLine("Error al agregar, el dni está en la lista");
        }
        else
        {
            personas.Add(dni, nommbre);
            Console.WriteLine("Persona añadida correctamente");
        }
    }
    // R obtener datos
    public void ObtenerPersona(string dni)
    {
        string value = personas.GetValueOrDefault(dni, "sin resultados");
        Console.Write("El nombre del usuario es: " + value);
        /* if (value != null)
        {
            Console.Write("El nombre del usuario es: " + value.Length);
        }
        else
        {
            Console.Write("Persona no encontrada");
        } */
    }
    // R listar datos
    // como podemos listar todos los datos de un array o un list for(0..length-1/count-1)
    // -1 [1qwe,qwe,qwe,wet,ryt,u,yry,retew,,eyr,et,we,e,r]
    public void ListarTodos()
    {
        foreach (KeyValuePair<string, string> item in personas)
        {
            Console.WriteLine(item.Key + " " + item.Value);
        }
    }


    // U actualizar datos
    // D borrar datos
    public bool BorrarDatos(string dni)
    {
        // 001F -> false
        // existe clase
        return personas.Remove(dni);
    }

    public void MostrarPrimerDato()
    {
        Console.WriteLine("El elemento en la primera posicion es " + personas["001K"].ToString());
    }




}