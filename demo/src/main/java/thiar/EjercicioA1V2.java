package thiar;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class EjercicioA1V2 {
    boolean ejecutando;

    public EjercicioA1V2() {
        this.ejecutando = true;
    }

    public void muestraInfoRuta(File ruta) {
        File[] listaPadre = ruta.listFiles();
        if (listaPadre != null) {
            Arrays.sort(listaPadre, (file1, file2)-> {
                if (file1.isDirectory()) {
                    return -1;
                }
                return 1;
            });
        }
        if (!ruta.exists()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("La ruta ingresada no Existe");
                e.printStackTrace();
            }
        } else {
            if (!ruta.isDirectory()) {
                System.out.println("[A] " + ruta.getName());
            } else if (ruta.isDirectory()) {
                System.out.println("* " + ruta.getName());
                File[] susNodosHijos = ruta.listFiles();
                Arrays.sort(susNodosHijos, (file1, file2)-> {
                    if (file1.isDirectory()) {
                        return -1;
                    }
                    return 1;
                });
                if (susNodosHijos != null) {
                    for (File file : susNodosHijos) {
                        muestraInfoRuta(file);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        EjercicioA1V2 instantaciaEjercicioA1V2 = new EjercicioA1V2();
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8.name());
        File actualDirectorio = new File(System.getProperty("user.dir"));

        while (instantaciaEjercicioA1V2.ejecutando) {
            System.out.println("Ingrese la ruta que esta buscando");
            String rutaBuscada = sc.nextLine().trim();
            File nFile = new File(rutaBuscada);
            File archivoABuscar;
            if (!nFile.isAbsolute()) {
                archivoABuscar = new File(actualDirectorio, rutaBuscada);
            } else {
                archivoABuscar = new File(rutaBuscada);
            }
            System.out.println("Ruta ingresada: " + rutaBuscada);
            System.out.println("Padre de la ruta ingresada: " + archivoABuscar.getParent());
            System.out.println("Ruta absoluta construida: " + archivoABuscar.getAbsolutePath());
            instantaciaEjercicioA1V2.muestraInfoRuta(archivoABuscar);
            if (rutaBuscada.equals("")) {
                instantaciaEjercicioA1V2.setEjecutando(false);
            }
        }
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

}
