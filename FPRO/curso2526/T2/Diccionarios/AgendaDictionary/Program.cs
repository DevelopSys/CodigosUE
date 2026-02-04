// guardar los valores par key-value de un conjunto de personas
// tipo key, vale
// Dictionary<string, string> listaContactos = new Dictionary<string, string>();
// Create Read Update Delete
// Añadir elemento
// [(1234A,BMH),(2345B,MLH)]
// listaContactos.Add("1234A", "Borja Martin Herrera");
// listaContactos["2345B"] = "Maria Lopez Hurtado";
// listaContactos.Add("1234A", "Luis Gomez Martin"); los elementos no se sobreescriben

// Consultar un dato asociado a una key
/*string datoRecuperado = listaContactos["88888A"]; // esto puede fallar
if (listaContactos.TryGetValue("2345678", out string nombre))
{
   Console.WriteLine("El dato recuperado es " + nombre);
}
else
{
   Console.WriteLine("El dni indicado no existe dentro de la lista");
}
/*listaContactos["1234A"] = "Nuevo Borja Martin";
if (listaContactos.TryGetValue("1234A", out string dato))
{
   Console.WriteLine("El dato recuperado es " + dato);
}*/
/* listaContactos.Remove("1234A");
if (listaContactos.TryGetValue("1234A", out string nombre))
{
    Console.WriteLine("El contacto tiene como nombre " + nombre);
}
else
{
    Console.WriteLine("El contacto no esta en la lista");
} */
// recorrer todos los elementos -> foreach
/* foreach (var contacto in listaContactos)

{
    // contacto es un par clave valor -> key: dni value: nombre apellido
    // Console.WriteLine("El dni del usuario es " + contacto.Key);
    Console.WriteLine("El nombre del usuario es " + contacto.Value);

} */
/* Dictionary<string, string> agenda = new Dictionary<string, string>();
Console.WriteLine("Por favor introduce 5 contactos, indicando su dni y su nombre");
for (int i = 0; i < 5; i++)
{
    Console.WriteLine("Indica el dni del usuario");
    string? dni = Console.ReadLine();
    Console.WriteLine("Indica el nombre del usuario");
    string? nombre = Console.ReadLine();
    // agenda.TryAdd(nombre, dni);
    agenda.Add(dni, nombre);
} */



// mediante un menu hagais una agenda
/*
1. Agregar usuarios. Pide nombre dni(key). en caso de ser una key duplicada aviso del error y no agrego
2. Buscar usuario. Pide el dni y muestra el nombre asociado. En caso de no exisitir
    indica que el usuario no existe y pregunta si quiero añadirlo
3. Eliminar usuario de la lisa. Pide el dni y indica el nombre del usuario borrado, en caso
    de no estar, indica que el dni no esta en la lista
4. Mostrar todos los usuarios. No pide nada y recorre la lista completa
*/
Dictionary<string, string> listaPersonas = new Dictionary<string, string>();
int opcion = -1;
string? dni;
do
{
    Console.WriteLine("1 Agregar usuario");
    Console.WriteLine("2 Buscar usuario");
    Console.WriteLine("3 Eliminar usuario");
    Console.WriteLine("4 Mosrar usuarios");
    Console.WriteLine("5 Salir");
    opcion = Int16.Parse(Console.ReadLine());
    switch (opcion)
    {
        case 1:
            // pide el dni
            Console.WriteLine("Introduce el dni");
            dni = Console.ReadLine();
            if (listaPersonas.ContainsKey(dni!))
            {
                Console.WriteLine("El dni esta en la lista, no se puede agregar");
            }
            else
            {
                /* // pide el nombre del usuario
                Console.WriteLine("Introduce el nombre");
                string? nombre = Console.ReadLine();
                // listaPersonas.TryAdd(dni!, nombre!); -> true
                listaPersonas[dni!] = nombre!; */
                string? nombre = Console.ReadLine();
                AgregarUsuario(dni!, nombre!);
                /* listaPersonas[dni!] = usuario!;
                    Console.WriteLine($"Usuario con nombre {usuario}"); */
            }

            break;
        case 2:
            Console.WriteLine("Introduce el dni");
            dni = Console.ReadLine();
            // ver si esta
            if (listaPersonas.TryGetValue(dni!, out string usuario))
            {
                //  persona encontrada correctamente
                Console.WriteLine($"Ususario encontrado con nombre {usuario}");
            }
            else
            {
                Console.WriteLine("El dni no esta en la lista");
                Console.WriteLine("Queres añadirlo (s/n)");
                string lectura = Console.ReadLine();
                if (lectura == "s")
                {
                    Console.WriteLine("Indica el nombre a asociar");
                    string nombreAsociar = Console.ReadLine();
                    AgregarUsuario(dni, nombreAsociar);
                }
            }
            break;
        case 3:
            Console.WriteLine("Introduce el dni que quieres borrar");
            dni = Console.ReadLine();
            EliminarUsuario(dni);
            break;
        case 4:
            MostrarUsuarios();
            break;
        case 5:
            Console.WriteLine("Saliendo......");
            break;
        default:
            Console.WriteLine("Caso no contemplado");
            break;
    }


} while (opcion != 5);


bool EstaUsuario(string dni)
{
    // secuencia logica
    return listaPersonas.ContainsKey(dni);
}

void EliminarUsuario(string dni)
{
    // si existe en la lista
    if (listaPersonas.Remove(dni, out string usuarioBorrado))
    {
        Console.WriteLine($"Usuario borrado correctamente con nombre {usuarioBorrado}");
    }
    else
    {
        Console.WriteLine("DNI no encontrado, usuario no borrado");
    }
}

void MostrarUsuarios()
{
    if (listaPersonas.Count == 0)
    {
        Console.WriteLine("No hay usuarios, lista vacia");
    }
    else
    {
        foreach (var usuario in listaPersonas)
        {
            Console.WriteLine($"DNI {usuario.Key} NOMBRE {usuario.Value}");
        }
    }
}

void AgregarUsuario(string dni, string usuario)
{
    // pide el nombre del usuario
    // Console.WriteLine("Introduce el nombre");
    // string? nombre = Console.ReadLine();
    // listaPersonas.TryAdd(dni!, nombre!); -> true
    listaPersonas[dni!] = usuario!;
    Console.WriteLine($"Usuario con nombre {usuario}");
}