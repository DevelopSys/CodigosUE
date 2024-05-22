package ejercicio2;


import ejercicio1.controller.Colegio;
import ejercicio2.model.Alumno;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Entrada {

    public static void main(String[] args) {
        // FILE -> FILEREADER (int->char) -> BUFFEREDREADER (String)
        File file = new File("src/ejercicio2/resources/alumnos.txt");
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String nombreMax = "";
        int notaMax = 0;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] alumnoString = linea.replaceAll(" ", "").split(",");
                // Alumno alumno = new Alumno(alumnoString[0], alumnoString[1], alumnoString[2], Integer.parseInt(alumnoString[3]));
                // ordenar por alumno
                // listaAlumnos.add(alumno);
                // hay linea leida
                // Celia,Lopez,celia@gmailcom,9
                linea = linea.replaceAll(" ","");
                if (Integer.parseInt(linea.split(",")[3])>notaMax){
                    notaMax = Integer.parseInt(linea.split(",")[3]);
                    nombreMax = linea.split(",")[0] + " "+linea.split(",")[1];
                };
            }

            /*Collections.sort(listaAlumnos, new Comparator<Alumno>() {
                @Override
                public int compare(Alumno o1, Alumno o2) {
                    if (o1.getNota() > o2.getNota()) {
                        return -1;
                    } else if (o1.getNota() < o2.getNota()) {
                        return 1;
                    } else
                        return 0;
                }
            });*/

            System.out.printf("El alumno con la nota mas alta es %s con una nota de %d", nombreMax, notaMax);
            // System.out.printf("El alumno con la nota mas alta es %s con una nota de %d",
            //         listaAlumnos.get(0).getNombre(), listaAlumnos.get(0).getNota());

        } catch (FileNotFoundException e) {
            System.out.println("Ruta no valida");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
