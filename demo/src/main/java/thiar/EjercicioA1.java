package thiar;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EjercicioA1 {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Ingrese la ruta a buscar");
            Scanner scanner = new Scanner(System.in);
            String rutaABuscar = scanner.nextLine();
            File archivo = new File(rutaABuscar);
            if (rutaABuscar == "") {
                break;
            }
            try (Scanner sc = new Scanner(archivo, StandardCharsets.UTF_8.name())) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

}
