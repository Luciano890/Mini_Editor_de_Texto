package gui;

import comunicacion.IArchivador;
import comunicacion.PArchivador;

public class Test {

    public static void main(String[] args) {
        IArchivador archivador=PArchivador.obtenerArchivador();
        System.out.println(archivador.guardar("C:\\Users\\chava\\OneDrive\\Escritorio\\Pruebas.txt", "y las paisas son boletas"));
        System.out.println(archivador.cargar("C:\\Users\\chava\\OneDrive\\Escritorio\\Pruebas.txt"));
    }
    
}
