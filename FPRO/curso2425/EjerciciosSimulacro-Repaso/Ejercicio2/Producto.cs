class Producto
{
    private string nombre;
    private int stock;
    private double precio;

    public Producto(string nombre, int stock, double precio)
    {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public int getStock()
    {
        return this.stock;
    }
    public double getPRecio()
    {
        return this.precio;
    }

    public string getNombre()
    {
        return this.nombre;
    }
    public void MostrarDatos()
    {
        Console.WriteLine("nombre " + nombre);
        Console.WriteLine("precio " + precio);
        Console.WriteLine("stock " + stock);
    }
}