package controller;

import model.Libro;
import model.LibroComedia;
import model.LibroPoliciaca;
import model.LibroTerror;
import utils.ExceptionCatalogo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Biblioteca<T extends Libro> {

    private String tipo;
    private String nombre;
    private String director;
    // CATALOGO
    private Catalogo catalogo;

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public void buscarLibro(String isbn){
        try {
            if (catalogo!=null){
            catalogo.buscarLibro(isbn);
            } else {
                throw new ExceptionCatalogo("No hay catalogo");
            }
        } catch (ExceptionCatalogo e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarLibros() throws ExceptionCatalogo {
        if (catalogo!=null){

        catalogo.listarLibros();
        } else {
            throw new ExceptionCatalogo("No hay catalogo");
        }
    }

    public void agregarLibro(T libro) throws ExceptionCatalogo {
        if (catalogo==null){
            throw new ExceptionCatalogo("No hay catalogo creado");
        } else {
            catalogo.agregarLibroCatalogo(libro);
        }
        // y si no tengo catalogo -> no hay acceso a agregarLibroCatalogo();
    }

    public void construirCatalgo(int numeroLibros) throws ExceptionCatalogo {
        if (catalogo!= null){
            throw new ExceptionCatalogo("Ya existe un catalogo");
        } else {
            this.catalogo = new Catalogo();
            //this.catalogo.setNumeroLibros(numeroLibros);
            this.catalogo.numeroLibros = numeroLibros;
        }

    }
    public void exportarCatalogo() throws ExceptionCatalogo {
        if (catalogo!=null){

        catalogo.exportarLibros();
        } else {
            throw new ExceptionCatalogo("No se ha podido exportar porque es nulo");
        }
    }

    class Catalogo {
        private ArrayList<T> libros;
        private int numeroLibros;

        public Catalogo() {
            libros = new ArrayList<>();
        }

        public void agregarLibroCatalogo(T libro) throws ExceptionCatalogo {

            /*switch (tipo){
                case "Terror":
                    if (libro instanceof LibroTerror){
                        //agregar
                    } else {
                        // falla
                    }
                    break;
                case "Policiaca":
                    if (libro instanceof LibroPoliciaca){
                        //agregar
                    } else {
                        // falla
                    }
                    break;
                case "Humor":
                    if (libro instanceof LibroComedia){
                        //agregar
                    } else {
                        // falla
                    }
                    break;
                case "General":
                    // agregar


            }*/
            if (libros.size()==numeroLibros){
                throw new ExceptionCatalogo("No hay hueco en el catalogo");
            } else {
                libros.add(libro);
            }

        }

        public void listarLibros(){
            for (T libro : libros ) {
                libro.mostrarDatos();
            }
        }

        public ArrayList<T> getLibros() {
            return libros;
        }

        public void buscarLibro(String isbn) throws ExceptionCatalogo {

            boolean estaLibro = false;

            for ( T libro : libros ) {
                if (libro.getIsbn().equals(isbn)){
                    estaLibro = true;
                    libro.mostrarDatos();
                    break;
                }
            }

            if (!estaLibro){
                throw new ExceptionCatalogo("No se ha encontrado el libro correspondiente");
            }


        }

        public void exportarLibros(){

            File file = new File("src/resources/libros.obj");
            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                objectOutputStream.writeObject(libros);
            } catch (IOException e) {
                System.out.println("Fallo en escritura");
            } finally {
                try {
                    objectOutputStream.close();
                } catch (IOException | NullPointerException e) {
                    System.out.println("Fallo en cerrado");
                }
            }

        }

        public void setLibros(ArrayList<T> libros) {
            this.libros = libros;
        }

        public int getNumeroLibros() {
            return numeroLibros;
        }

        public void setNumeroLibros(int numeroLibros) {
            this.numeroLibros = numeroLibros;
        }
    }
}
