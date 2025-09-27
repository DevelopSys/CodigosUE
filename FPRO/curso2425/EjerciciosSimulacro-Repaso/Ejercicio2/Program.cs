public class Entrada
{
    public static void Main(string[] args)
    {

        Tienda tienda = new Tienda();

        // Producto p = new Producto("Camiseta", 3, 20.0)
        tienda.AgregarProducto(new Producto("Camiseta", 3, 20.0));
        tienda.AgregarProducto(new Producto("Pantalon", 2, 10.0));
        tienda.AgregarProducto(new Producto("Zapatillas", 6, 40.0));
        tienda.ListarProductor();
        Console.WriteLine("El total de la tienda es " + tienda.GetTotal());
    }
}