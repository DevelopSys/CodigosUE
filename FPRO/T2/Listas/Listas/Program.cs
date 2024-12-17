// VISTA
public class MyClass
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Bienvenido al programa de listas");
        Funcionalidad funcionalidad = new Funcionalidad();
        // donde tengo el attr listaPalabras

        funcionalidad.AgregarElemento("Hola");
        funcionalidad.AgregarElemento(new string[] { "Adios", "Que", "tal", "estas" });

        // count -> 5
        // capacity -> 8

        funcionalidad.ModificarElemento("Nuevo", 4);
        // count -> 6
        // capacity -> 8 

        // funcionalidad.BorrarElemento(1);
        if (funcionalidad.BorrarElemento("Hola"))
        {
            Console.WriteLine("Elemento borrado correctamente");
        }
        else
        {
            Console.WriteLine("Fallo al borrar, no se encuentra en la lista");
        }
        // listaPalabras.RemoveAt(0)
        // "Hola","Adios", "Que", "tal", "nuevo","estas"

        funcionalidad.ObtenerElemento(0);
        funcionalidad.ObtenerTodos();



    }
}