package thiar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioB2 {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("./resources/documentos/alumnos_notas.txt"), "UTF-8"))) {
            String linea;
            List<String> listaLineas = new ArrayList<>();
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
                String[] arrrayLinea = linea.split(" ");
                String nombreAlumno = arrrayLinea[0] + " " + arrrayLinea[1];
                double sumaNotas = 0;
                int numeroNotas = 0;
                for (int i = 2; i < arrrayLinea.length; i++) {
                    sumaNotas = sumaNotas + Double.parseDouble(arrrayLinea[i]);
                    numeroNotas++;
                }
                double notaMedia = sumaNotas/numeroNotas;
                String lineaFinal = nombreAlumno + " " + notaMedia;
                listaLineas.add(lineaFinal);
            }
            /* listaLineas.sort((s1, s2) -> {
                double nota1 = Double.parseDouble(s1.split(" ")[2]);
                double nota2 = Double.parseDouble(s2.split(" ")[2]);
                return Double.compare(nota1, nota2);
            }); */
            Collections.sort(listaLineas, (s1,s2)->{
                double notaS1 = Double.parseDouble(s1.split(" ")[2]);
                double notaS2 = Double.parseDouble(s2.split(" ")[2]);
                return Double.compare(notaS1, notaS2);

            });
            for (String lineaCompleta : listaLineas) {
                String[] lineaDividida = lineaCompleta.split(" ");
                String nombreAlumno = lineaDividida[0] + " " + lineaDividida[1];
                String notasMediaStr = lineaDividida[2];
                String resultado = "Noda media del alumno " + nombreAlumno + " es: " + notasMediaStr;
                System.out.println(resultado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
