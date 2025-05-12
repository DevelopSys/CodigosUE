class Tienda
{
    private List<Producto> listaProductos;

    public Tienda()
    {
        listaProductos = new List<Producto>();
    }

    public void AgregarProducto(Producto p)
    {
        this.listaProductos.Add(p);
    }

    public void ListarProductor()
    {
        foreach (var item in listaProductos)
        {
            item.MostrarDatos();
        }
    }

    public void BuscarProducto(string nombre)
    {
        foreach (var item in listaProductos)
        {
            if (item.getNombre() == nombre)
            {
                item.MostrarDatos();
            }
        }
    }

    public double GetTotal()
    {
        double total = 0.0;

        foreach (var item in listaProductos)
        {
            total += (item.getPRecio() * item.getStock());
        }

        return total;
    }
}