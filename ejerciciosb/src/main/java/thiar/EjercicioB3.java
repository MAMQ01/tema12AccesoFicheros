package thiar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioB3 {

    public static void main(String[] args) {
        System.out.println("Ingrese el archivo A:");
        String archivoA = "./resources/documentos/usa_personas.txt";
        String archivoB = "usa_personas_ordenadas.txt";
        String linea;
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream(archivoA)))) {
            File ubicacionArchivoB = new File("./resources/documentos", archivoB);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ubicacionArchivoB)));
            List<String> listaLinea = new ArrayList<>(); 
            while ((linea = lector.readLine()) != null) {
                listaLinea.add(linea);
                System.out.println(linea);
            }
            Collections.sort(listaLinea);
            for (String string : listaLinea) {
                bufferedWriter.write(string);
                bufferedWriter.write('\n');
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
