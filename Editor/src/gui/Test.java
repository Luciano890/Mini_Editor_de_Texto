package gui;

import comunicacion.IArchivador;
import comunicacion.PArchivador;

public class Test {

    public static void main(String[] args) {
        IArchivador archivador=PArchivador.obtenerArchivador();
//        System.out.println(archivador.guardar("C:\\Users\\chava\\OneDrive\\Escritorio\\Pruebas2.txt", "Hola Mundo!!"));
        System.out.println(archivador.cargar("C:\\Users\\chava\\OneDrive\\Escritorio\\Ideas_Aplicaciones.txt"));
    }
    
}
