package thiar;

import java.io.File;
import java.util.Scanner;

public class EjercicioB4 {

    public static void devuelveHijos(File file) {
        System.out.println("El hijo de: " + file.getParent() + " es: " + file.getName());
        if (file.isDirectory()) {
            File[] hijosFile = file.listFiles();
            if (hijosFile == null) {
                System.out.println("No se pudo leer su documento porque es null");
            } else if (hijosFile != null) {
                if (hijosFile.length > 0) {
                    for (File file2 : hijosFile) {
                        devuelveHijos(file2);
                    }
                } else {
                    System.out.println("Su directorio no tiene contenido");
                }
            }
        } else {
            System.out.println("El archivo: " + file.getName() + " es hijo de: " + file.getParentFile().getName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File carpetaActual = new File(System.getProperty("user.dir"));
        System.out.println("Introduzca la ruta absoluta a imprimir");
        String ubicacion = sc.nextLine();
        File fileBuscada;
        File fileBuscadaAux = new File(ubicacion);
        if (fileBuscadaAux.isAbsolute()) {
            fileBuscada = fileBuscadaAux;
        } else {
            fileBuscada = new File(carpetaActual, ubicacion);
        }
        if (fileBuscada.exists()) {
            devuelveHijos(fileBuscada);
        }
    }
}