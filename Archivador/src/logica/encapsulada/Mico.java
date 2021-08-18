package logica.encapsulada;

import comunicacion.IArchivador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class Mico implements IArchivador{

    @Override
    public boolean guardar(String archivo, String texto) {
        try {
            PrintStream salida=new PrintStream(archivo);
            salida.println(texto);
            salida.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String cargar(String archivo) {
        try {
            BufferedReader entrada=new BufferedReader(new FileReader(archivo));
            String contenido="";
            String linea=entrada.readLine();
            while (linea!=null) {
                contenido+=linea;
                linea=entrada.readLine();
            }
            entrada.close();
            return contenido;
        } catch (Exception e) {
            return null;
        }
    }

  
    
}
