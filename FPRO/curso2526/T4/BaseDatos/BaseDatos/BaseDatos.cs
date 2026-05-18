using Microsoft.Data.SqlClient;

public class MyClass
{

    static async Task Main()
    {
        // jdbc:mysql://127.0.0.1:3306/nombreBd,root, roo
        string url = "Server=127.0.0.1;Database=ejemplo;User ID=root;Password=root";
        using var connection = new SqlConnection(url);
        // Async -> esto se va a ejecutar en el hilo de segundo plano
        // await -> espera a que la operacion termine y cuando este ok ejecuta las siguientes cosas de las que depende
        await connection.OpenAsync();
        // crear un comando -> para poder ejecutar querys
        // ejecutar el comando
        // en modo INSERT / UPDATE / DELETE ExecuteNonQuery()
        // en modo SELECT ExecuteReader()
        using SqlCommand command = connection.CreateCommand();
        // SqlCommand command = new SqlCommand("",connection);
        command.CommandText = "SELECT * FROM usuarios WHERE nombre = @parametro";
        command.Parameters.AddWithValue("parametro", "prueba");
        using var reader = await command.ExecuteReaderAsync();
        // R1 {n,a,d} R2 {n,a,d} R3 {n,a,d}
        while (await reader.ReadAsync())
        {
            Console.WriteLine($"Nombre: {reader["nombre"]} Apellido: {reader["apellido"]}");
        }


        command.CommandText = "INSERT INTO usuarios (nombre, apellido, dni) VALUES (@nombre, @apellido, @dni)";
        command.Parameters.AddWithValue("nombre", "Borja");
        command.Parameters.AddWithValue("apellido", "Martin");
        command.Parameters.AddWithValue("dni", "1234A");
        int rows = command.ExecuteNonQuery();
        Console.WriteLine("El numero de filas afectas es de " + rows);

        // using var reader = await command.ExecuteReaderAsync();


    }


}