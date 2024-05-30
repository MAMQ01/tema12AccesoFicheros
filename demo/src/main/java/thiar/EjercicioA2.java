package thiar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class EjercicioA2 {

    public void muestraInfoRuta(File ruta) {
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
                File[] susNodosHijos = ruta.listFiles();
                Arrays.sort(susNodosHijos, (file1, file2)-> {
                    if (file1.isDirectory()) {
                        return -1;
                    }
                    return 1;
                });
                System.out.println("* " + ruta.getName());
                if (susNodosHijos != null) {
                    for (File file : susNodosHijos) {
                        muestraInfoRuta(file);
                    }
                }
            }
        }
    }

    public void info() {

    }

}