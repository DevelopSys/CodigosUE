import controller.Biblioteca;
import model.Libro;
import model.LibroComedia;
import model.LibroPoliciaca;
import model.LibroTerror;
import utils.ExceptionCatalogo;

public class Entrada {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("BibliotecaTerror","Director");
        //Biblioteca<LibroComedia> biblioteca1 = new Biblioteca("BibliotecaComedia","Director");
        //Biblioteca<LibroPoliciaca> biblioteca2 = new Biblioteca("BibliotecaPoliciaca","Director");
        //Biblioteca<Libro> biblioteca3 = new Biblioteca("BibliotecaGenerica","Director");


        /*switch ("tipo"){
            case "Terror":
                biblioteca = new Biblioteca<LibroComedia>("","");
                break;
        }*/

        try{
            biblioteca.construirCatalgo(4);
        } catch (ExceptionCatalogo e){
            System.out.println(e.getMessage());
        }

        // agregar un libro al catalogo
        try {
            /*biblioteca1.construirCatalgo(3);
            biblioteca1.agregarLibro(new LibroComedia());
            biblioteca2.construirCatalgo(4);
            biblioteca2.agregarLibro(new LibroPoliciaca());
            biblioteca3.construirCatalgo(5);
            biblioteca3.agregarLibro(new LibroTerror());
            biblioteca3.agregarLibro(new LibroComedia());
            biblioteca3.agregarLibro(new LibroPoliciaca());*/


            // biblioteca.construirCatalgo(4);
            // tring autor, int numeroPaginas, String isbn, int calificacion
            // biblioteca.agregarLibro(new LibroComedia());
            biblioteca.agregarLibro(new LibroTerror("autor1",123,"123",18));
            biblioteca.agregarLibro(new LibroTerror("autor2",123,"124",20));
            biblioteca.agregarLibro(new LibroTerror("autor3",123,"125",22));
            biblioteca.agregarLibro(new LibroTerror("autor4",123,"125",22));
            biblioteca.agregarLibro(new LibroTerror("autor5",123,"125",22));
            // biblioteca.buscarLibro("123");


        } catch (ExceptionCatalogo e) {
            System.out.println(e.getMessage());
        }

        try{
            biblioteca.listarLibros();
        } catch (ExceptionCatalogo exceptionCatalogo){
            System.out.println(exceptionCatalogo.getMessage());
        }

        try {
            biblioteca.exportarCatalogo();
        } catch (ExceptionCatalogo e) {
            System.out.println(e.getMessage());
        }


    }

}
