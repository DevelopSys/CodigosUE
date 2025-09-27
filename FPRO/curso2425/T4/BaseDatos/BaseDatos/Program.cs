using MySql.Data.MySqlClient;
public class MyClass
{
    // Server=localhost - 127.0.0.1:3306
    // Database=usuariodb
    // Uid=root
    // Pwd= 
    static string dataConnection = "Server=localhost;Database=usuariosdb;Uid=root;Pwd=;";
    public static void Main(string[] args)
    {
        MySqlConnection? connection = null;
        // exception a capturar
        try
        {
            connection = new MySqlConnection(dataConnection);
            Console.WriteLine("Conexion correcta");
            // INSERT -> INSERT INTO usaurios (nombre, email, password) VALUES ('asd','asd','asd)
            // INSERT -> INSERT INTO usaurios (nombre, email, password) VALUES (@nombre,@mail,@password)
            //MySqlCommand command = new MySqlCommand("INSERT INTO usaurios (nombre, email, password) VALUES ('Borja','borja@c.com','asdasd123123)");
            MySqlCommand commandInsert = new MySqlCommand();
            commandInsert.CommandType = System.Data.CommandType.Text;
            commandInsert.Connection = connection;
            // command.CommandText = "INSERT INTO usaurios (nombre, email, password) VALUES ('Borja','borja@c.com','asdasd123123)";
            commandInsert.CommandText = "INSERT INTO usaurios (nombre, email, password) VALUES (@nombre,@correo,@pass)";
            commandInsert.Parameters.AddWithValue("@nombre", "Borja");
            commandInsert.Parameters.AddWithValue("@correo", "borjafundamentos@ue.com");
            commandInsert.Parameters.AddWithValue("@pass", "Borja123ue");
            int resultado = commandInsert.ExecuteNonQuery();


            MySqlCommand commandSelect = new MySqlCommand();
            commandSelect.CommandType = System.Data.CommandType.Text;
            /* commandSelect.CommandText = "SELECT * FROM usuarios WHERE salario > @salario";
            commandSelect.Parameters.AddWithValue("@salario",1000); */
            commandSelect.CommandText = "SELECT * FROM usuarios";
            MySqlDataReader dataReader = commandSelect.ExecuteReader(); // tupla de datos que me retorna la select
            //  v 
            //  R1 R2 R3 R4 
            while (dataReader.Read())
            {
                // acceder mediante la posicion de la columna (1)
                // int id = dataReader.GetInt32(1);
                Console.WriteLine( dataReader["email"]);
                Console.WriteLine(dataReader["nombre"]);
                Console.WriteLine(dataReader["pass"]);
                Console.WriteLine(int.Parse(dataReader["id"].ToString()));

            }
        }
        catch (MySqlException exception)
        {
            Console.WriteLine("Erroe en la conexion con la base de datos");
            Console.WriteLine(exception.Message);
        }
        finally
        {
            // Cerrar flujos
            connection?.Close();
        }
    }
}