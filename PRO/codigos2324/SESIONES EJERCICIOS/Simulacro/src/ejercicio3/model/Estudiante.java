package ejercicio3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Estudiante implements Serializable {

    private final static long serialVersionUID = 123123L;
    private String nombre;
    private int nota1, nota2, nota3;

    public Estudiante(String nombre, int nota1, int nota2, int nota3) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public Estudiante() {

    }

    public void caluclarMedia() {
        double media = (double) (nota1 + nota2 + nota3) / 3;
        System.out.println(media);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return nota1 == that.nota1 && nota2 == that.nota2 && nota3 == that.nota3 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota1, nota2, nota3);
    }

    public static ArrayList<Estudiante> leerEstudiante(String nombre) throws IOException {
        ArrayList<Estudiante> listaLeida = new ArrayList<>();

        // lectura
        File file = new File(nombre);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // lectura
        String linea = null;
        while ((linea = bufferedReader.readLine()) != null) {
            // paso de elemento leido a objeto usuario
            // Borja,3,6,8
            System.out.println(linea);
            String[] elementos = linea.split(",");
            Estudiante estudiante = new Estudiante(elementos[0], Integer.valueOf(elementos[1]), Integer.valueOf(elementos[2]), Integer.valueOf(elementos[3]));
            listaLeida.add(estudiante);
        }


        bufferedReader.close();


        return listaLeida;
    }

    public static void escribirEstudiantes() throws IOException {

        File file = new File("src/ejercicio3/resources/estudiantes.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        // escribir
        objectOutputStream.writeObject(new Estudiante("Borja1",4,5,3));
        objectOutputStream.writeObject(new Estudiante("Borja2",6,7,9));
        objectOutputStream.writeObject(new Estudiante("Borja3",4,2,1));

        objectOutputStream.close();


    }

    public static void leerEstudiantes() throws IOException, ClassNotFoundException, ClassCastException {

        File file = new File("src/ejercicio3/resources/estudiantes.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        // lectura
        Estudiante estudiante = (Estudiante) objectInputStream.readObject();
        System.out.println(estudiante);
        estudiante = (Estudiante) objectInputStream.readObject();
        System.out.println(estudiante);
        estudiante = (Estudiante) objectInputStream.readObject();
        System.out.println(estudiante);

        objectInputStream.close();


    }
}
