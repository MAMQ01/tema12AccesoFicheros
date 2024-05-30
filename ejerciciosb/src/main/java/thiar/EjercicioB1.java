package thiar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjercicioB1 {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("ejerciciosb/resources/documentos/numeros.txt"))) {
            List<Integer> listaNumeros = new ArrayList<Integer>();
            String linea;
            int numMenor = Integer.MAX_VALUE;
            int numMayor = Integer.MIN_VALUE;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
                int numeroLeido = Integer.parseInt(linea);
                listaNumeros.add(numeroLeido);
            }
            for (Integer integer : listaNumeros) {
                if (integer > numMayor) {
                    numMayor = integer;
                    System.out.println(numMayor + "_____________________________________ Mayor");
                }
                if (integer < numMenor) {
                    numMenor = integer;
                    System.out.println(numMenor + "_____________________________________ Menor");
                }
            }
            System.out.println("El número mayor es: " + numMayor);
            System.out.println("El número menor es: " + numMenor);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
