package thiar;

import java.io.File;
import java.util.Scanner;

public class EjercicioB4 {

    public static void devuelveHijos(File file) {
        System.out.println("El hijo de: " + file.getParentFile().getName() + " es: " + file.getName());
        if (file.isDirectory()) {
            File[] listaHijosFile = file.listFiles();
            if (listaHijosFile != null) {
                for (File file2 : listaHijosFile) {
                    if (listaHijosFile.length > 0) {
                        devuelveHijos(file2);
                    } else {
                        System.out.println("El padre de: " + file.getName() + " es: " + file.getParentFile().getName());
                    }
                }
            } else {
                System.out.println("Su archivo no tiene hijos está en null");
            }
        } else {
            System.out.println(
                    "El archivo: " + file.getName() + " tiene como padre a : " + file.getParentFile().getName());
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
        if (fileBuscada.isDirectory()) {
            File[] hijosRutaRaiz = fileBuscada.listFiles();
            if (hijosRutaRaiz != null) {
                for (File file : hijosRutaRaiz) {
                    devuelveHijos(file);
                }
            } else {
                System.out.println("Hijos de ruta raiz introducida está en null");
            }
        } else {
            System.out.println((fileBuscada.getParent() != null) ? ("El archivo: " + fileBuscada.getName() + " tiene como padre a : " + fileBuscada.getParentFile().getName()) : (fileBuscada.getName() + "No tiene padre"));
        }
    }
}