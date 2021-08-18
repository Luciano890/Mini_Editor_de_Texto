package comunicacion;

public interface IArchivador {

   public boolean guardar(String archivo, String texto);
   public String cargar(String archivo);
   
    
}
