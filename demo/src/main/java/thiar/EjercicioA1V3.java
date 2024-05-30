package thiar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EjercicioA1V3 {

    
    public void muestraInfoRuta(File ruta) {
        
        if (!ruta.isDirectory()) {
            System.out.println("[A] " + ruta.getName());
        }
        if (ruta.isDirectory()) {
            System.out.println("* " + ruta.getName());
            File[] susNodosHijos = ruta.listFiles();
            for (File file : susNodosHijos) {
                muestraInfoRuta(file);
            }
        }
    }

    public static void main(String[] args) {
        EjercicioA1V2 instantacEjercicioA1V2 = new EjercicioA1V2();

        File rutaAbsoluta = new File(System.getProperty("user.dir"));
        File[] lista = rutaAbsoluta.listFiles();
        String rutaIngresada = rutaAbsoluta.getName();
        Scanner sc = new Scanner(System.in);
        instantacEjercicioA1V2.muestraInfoRuta(rutaAbsoluta);


        /* if (lista != null) {
            for (File file : lista) {
                System.out.println(file.getAbsolutePath());
            }
            Arrays.sort(lista, (file1, file2) -> {
                if (file1.isDirectory()) {
                    return -1;
                } else {
                    return 1;
                }
            });
        } */

        /* Arrays.sort(lista, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.isDirectory()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            
        }); */

        /* System.out.println("Despues de ordenar");
        if (lista != null) {
            for (File file : lista) {
                System.out.println(file.getAbsolutePath());
            }
        } */



        /* System.out.println("El cotenido dirección absoluta " + directorioRaizAbsoluta + " :");
        if (lista != null) {
            for (File file : lista) {
                if (file.isDirectory()) {
                    System.out.println("[DIR] " + file.getName());
                } else if (!file.isDirectory()) {
                    System.out.println("[FIC] " + file.getName());
                }
            }
        }
        while (rutaIngresada != "") {
            System.out.println("Escriba la ruta que desea buscar");
            rutaIngresada = sc.nextLine();
            File archivoABuscar = new File(rutaIngresada);
            if (archivoABuscar.isAbsolute()) {
                File archivoABuscarAux = new File(rutaIngresada);
            } else {
                File archivoABuscarAux = new File(directorioRaizAbsoluta, rutaIngresada);
            }
            if (lista == null) {
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                for (File file : lista) {
                    if (file.isDirectory()&& archivoABuscar.getName() == file.getName()) {
                        System.out.println("[DIR] " + file.getName());
                    } else if (!file.isDirectory()&& archivoABuscar.getName() == file.getName()) {
                        System.out.println("[FIC] " + file.getName());
                    }
                }
            }
        } */
        /*
         * while (true) {
         * System.out.println("Ingrese la ruta a buscar");
         * Scanner scanner = new Scanner(System.in);
         * String rutaABuscar = scanner.nextLine();
         * File archivo = new File(rutaABuscar);
         * if (rutaABuscar == "") {
         * break;
         * }
         * 
         * System.out.println(archivo.getParent());
         * File [] lista = archivo.listFiles();
         * if (!(lista == null)) {
         * for (File file : lista) {
         * System.out.println(file);
         * }
         * } else {
         * System.out.println("La lista está vacia");
         * }
         * }
         */

    }


}
