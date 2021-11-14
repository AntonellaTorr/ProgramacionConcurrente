package TpO3.LectorEscritor;

public class Escritor {
    private Libro libro;
    private boolean finalizoLibro;

    public void run (){
        while (!finalizoLibro){
            libro.empezarAEscribir();
            escribir();
            libro.terminarDeEscribir();
        }

    }
    public void escribir(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
