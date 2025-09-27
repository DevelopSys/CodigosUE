class Usuario
{
    public string nombre { get; set; }
    public string apellido { get; set; }
    public string correo { get; set; }
    public int telefono { get; set; }

    public Usuario(string nombre, string apellido, string correo, int telefono)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String ExportarDato()
    {
        return nombre + "," + apellido + "," + correo + "," + telefono;
    }

}