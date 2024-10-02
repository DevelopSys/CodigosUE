public class Entrada {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Biblioteca.Catalogo catalogo = biblioteca.new Catalogo();

        try {
            biblioteca.soltarMensajeBiblioteca();
        } catch (Exception e) {
            System.out.println("Error desde main");
        }

        //catalogo.mostrarMensajeCatalogo();

        Libro libro = new Libro();
    }
}
