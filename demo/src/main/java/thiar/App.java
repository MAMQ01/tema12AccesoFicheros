package thiar;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //Dos rutas absolutas
        File carpetaAbs = new File("/Documentos/");
        File archivoAbs = new File("/Documentos/Fotografias/boxeo.jpg");

        //Dos rutas relativas
        File carpetaRel = new File("Libros");
        File archivoRel = new File("Libros/lazarillo.txt");
        
        System.out.println("Mostrando carpetaAbs");
        mostrarRutas(carpetaAbs);

        System.out.println("Mostrando archivoAbs");
        mostrarRutas(archivoAbs);

        System.out.println("Mostrando carpetaRel");
        mostrarRutas(carpetaRel);
        
        System.out.println("Mostrando archivoRel");
        mostrarRutas(archivoRel);
        
        

    }
    
    public static void mostrarRutas(File f) {
        
        System.out.println("usando getParent() : " + f.getParent());
        System.out.println("usando getName() : " + f.getName());
        System.out.println("usando getAbsolutePath() : " + f.getAbsolutePath());
    }

}
