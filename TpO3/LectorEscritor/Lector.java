package TpO3.LectorEscritor;

public class Lector {
    private  boolean terminoLectura;
    private Libro libro;

    public void run (){
        while (!terminoLectura){
            if (libro.hayEscrito()){
                libro.empezarALeer();
                leer();
                libro.terminarDeLeer();

            }
            else{
                terminoLectura=true;
            }
        }
    }
    public void leer(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
