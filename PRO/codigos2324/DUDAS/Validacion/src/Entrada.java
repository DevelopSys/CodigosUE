import utils.DNILongException;
import utils.NombreApellidoException;
import utils.UltimoCaracterException;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String nombre="", apellido="", dni="";

        do{
            // nombre
            // apellido
            // dni
            // validar
            // salir
            System.out.println("1. Introducir nombre");
            System.out.println("2. Introducir apellido");
            System.out.println("3. Introducir dni");
            System.out.println("4. Validar datos");
            System.out.println("5. salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Introduce el nombre");
                    nombre = scanner.next();
                    break;
                case 2:
                    System.out.println("Introduce el apellido");
                    apellido = scanner.next();
                    break;
                case 3:
                    System.out.println("Introduce el dni");
                    dni = scanner.next();
                    break;
                case 4:
                    System.out.println("Validar");
                    try{
                        if (nombre.length()==0 || apellido.length() ==0){
                            throw new NombreApellidoException("Los datos no son validos");
                        }

                        if (dni.length()!=9){
                            throw new DNILongException("El dni no es valido");
                        }

                        char ultimo = dni.charAt(dni.length()-1);
                        if (Character.isDigit(ultimo)){
                            throw new UltimoCaracterException("No es una letra el ultimo");
                        }

                        System.out.println("Todos los datos han sido validados correctamente");

                    } catch (NombreApellidoException e){
                        System.out.println(e.getMessage());
                    } catch (DNILongException e){
                        System.out.println(e.getMessage());
                    } catch (UltimoCaracterException e){
                        System.out.println(e.getMessage());
                    }

                    // nombre - apellido -> longitud > 0


                    break;
            }
        }while (opcion!=5);
    }
}
