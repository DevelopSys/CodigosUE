class Operaciones
{

    private List<Usuario> listaUsuarios;
    public Operaciones()
    {
        listaUsuarios = new List<Usuario>();
        listaUsuarios.Add(new Usuario("Borja1", "Martin1", "bmartin@gmail.com1", 123456789));
        listaUsuarios.Add(new Usuario("Borja2", "Martin2", "bmartin@gmail.com2", 123456789));
        listaUsuarios.Add(new Usuario("Borja3", "Martin3", "bmartin@gmail.com3", 123456789));
        listaUsuarios.Add(new Usuario("Borja4", "Martin4", "bmartin@gmail.com4", 123456789));
        listaUsuarios.Add(new Usuario("Borja5", "Martin5", "bmartin@gmail.com5", 123456789));
        listaUsuarios.Add(new Usuario("Borja6", "Martin6", "bmartin@gmail.com6", 123456789));
        listaUsuarios.Add(new Usuario("Borja7", "Martin7", "bmartin@gmail.com7", 123456789));
        listaUsuarios.Add(new Usuario("Borja8", "Martin8", "bmartin@gmail.com8", 123456789));

    }
    public void ObtenerInformacion(String path)
    {
        Console.WriteLine("Leyendo el fichero " + path);
        /* Console.WriteLine("Last Access Time: " + File.GetLastAccessTime(path));
        Console.WriteLine("Atributos: " + File.GetAttributes(path));
        Console.WriteLine("Existe: " + File.Exists(path)); */
        /* FileInfo fileInfo = new FileInfo(path);
        Console.WriteLine("Last Access Time: " + fileInfo.LastAccessTime);
        Console.WriteLine("Atributo: " + fileInfo.Attributes);
        Console.WriteLine("Tamaño: " + fileInfo.Length);
        Console.WriteLine("Nombre: " + fileInfo.Name);
        Console.WriteLine("Directorio: " + fileInfo.Directory);
        Console.WriteLine("Exist: " + fileInfo.Exists); */
        //Console.WriteLine("Directorio raíz: " + fileInfo.Root);
        if (!File.Exists(path))
        {
            File.Create(path);
            Console.WriteLine("El fichero no existe, se ha creado");
        }
        else
        {
            Console.WriteLine("El fichero existe");
            FileInfo fileInfo = new FileInfo(path);
            Console.WriteLine("Last Access Time: " + fileInfo.LastAccessTime);
            Console.WriteLine("Atributo: " + fileInfo.Attributes);
            Console.WriteLine("Tamaño: " + fileInfo.Length);
            Console.WriteLine("Nombre: " + fileInfo.Name);
            Console.WriteLine("Directorio: " + fileInfo.Directory);
        }
    }

    public void EscribirFichero(String path)
    {
        FileStream fileStream = new FileStream(path, FileMode.Append);
        StreamWriter streamWriter = new StreamWriter(fileStream);
        streamWriter.WriteLine("Hola");
        streamWriter.Write(123);
        // siempre cierro el flujo de la informacion
        streamWriter.Close();
        fileStream.Close();
    }

    public void LeerFichero(String path)
    {
        // FileStream fileStream = new FileStream(path, FileMode.Open);
        // StreamReader streamReader = new StreamReader(fileStream);

        FileStream? fileStream = null;
        StreamReader? streamReader = null;

        try
        {
            fileStream = new FileStream(path, FileMode.Open);
            streamReader = new StreamReader(fileStream);
            String? linea = null;
            // Console.WriteLine(linea);
            while ((linea = streamReader.ReadLine()) != null)
            {
                Console.WriteLine(linea);
            }
        }
        catch (FileNotFoundException e)
        {
            Console.WriteLine("El fichero no existe");
            Console.WriteLine(e.Message);
        }
        catch (IOException e)
        {
            Console.WriteLine("Error de entrada/salida");
            Console.WriteLine(e.Message);
        }
        catch (Exception e)
        {
            Console.WriteLine("Error: " + e.Message);
        }
        finally
        {
            try
            {
                streamReader?.Close();
                fileStream?.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("Error al cerrar el fichero: " + e.Message);
            }

        }



        Console.WriteLine("Fin del fichero");

    }

    public void ExportarUsuarios(String path)
    {

        if (!File.Exists(path))
        {
            File.Create(path);
        }

        FileStream? fileStream = null;
        StreamWriter? streamWriter = null;


        try
        {
            fileStream = new FileStream(path, FileMode.Append);
            streamWriter = new StreamWriter(fileStream);

            foreach (var item in listaUsuarios)
            {
                streamWriter.WriteLine(item.ExportarDato());
            }
        }
        catch (FileNotFoundException e)
        {
            Console.WriteLine("El fichero no existe");
            Console.WriteLine(e.Message);
        }
        catch (IOException e)
        {
            Console.WriteLine("Error de entrada/salida");
            Console.WriteLine(e.Message);
        }

        finally
        {
            try
            {
                streamWriter?.Close();
                fileStream?.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("Error al cerrar el fichero: " + e.Message);
            }
        }

    }

}