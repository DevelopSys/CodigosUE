// LOGICA
public class Funcionalidad
{

    // variables -> caracteristicas de la clase y se declaran como privadas public private protected
    public List<string> listaPalabras;

    // constructor
    public Funcionalidad()
    {
        listaPalabras = new List<string>();

    }

    // agregarElementos
    public void AgregarElemento(string palabra)
    {
        // agregar un elemento a la lista de datos
        listaPalabras.Add(palabra);
        InformacionLista();
    }

    // sobrecargando metodos
    public void AgregarElemento(string[] lista)
    {
        // agregar muchos elementos a la lista de datos
        listaPalabras.AddRange(lista);
        InformacionLista();
    }

    // lo inserta y mueve el resto
    public void ModificarElemento(string elemento, int posicion)
    {
        listaPalabras.Insert(posicion, elemento);
        Console.WriteLine("Modificacion lista");
        InformacionLista();
    }

    public void BorrarElemento(int posicion)
    {
        // segun su posicion
        listaPalabras.RemoveAt(posicion);
        Console.WriteLine("Obtener info despues de borrar");
        InformacionLista();
    }

    public bool BorrarElemento(string valor)
    {
        // segun su valor
        bool borrado = listaPalabras.Remove(valor);
        Console.WriteLine("Obtener info despues de borrar");
        InformacionLista();
        return borrado;
    }


    public void ObtenerElemento(int posicion)
    {
        string elemento = listaPalabras.ElementAt(posicion);
        if (elemento != null)
        {
            Console.WriteLine($"elemento encontrado {elemento}");
        }
    }

    public void ObtenerTodos()
    {
        for (var i = 0; i < listaPalabras.Count; i++)
        {
            Console.WriteLine($"el elemento de la posicion {i} es {listaPalabras.ElementAt(i)}");
        }
    }

    private void InformacionLista()
    {
        Console.WriteLine($"Elemento agregado correctamente. El nuevo tamaño de la coleccion es de: {listaPalabras.Count}");
        Console.WriteLine($"La capacidad de la lista es de {listaPalabras.Capacity}");
    }



}