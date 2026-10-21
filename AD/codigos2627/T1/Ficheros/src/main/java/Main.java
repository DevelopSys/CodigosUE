import controller.FileController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileController controller = new FileController();
        Scanner scanner = new Scanner(System.in);
        /*
        System.out.println("Info de folder");
        System.out.println("Indica la ruta de la carpeta que quires analizar");
        String path = scanner.next();
        controller.getInfoFile(path);
        System.out.println("Indica la ruta del fichero que quires analizar");
        path = scanner.next();
        System.out.println("Info de example");
        controller.getInfoFile(path);*/
        // System.out.println("Indica el mensaje a escribir");
        // String mensaje = scanner.nextLine();
        // controller.writeFileTXT("example_write_line.txt", mensaje);
        controller.readFileTXT("example_write_line.txt");
    }


}
