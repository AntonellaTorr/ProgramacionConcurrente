package PracticaParcial.EjAutos;

public class HiloDeControl implements Runnable {
    private static GestorCruce g= new GestorCruce ();
    
    public HiloDeControl(){

    }
    public void run (){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.cambiarSemaforo();
    
        }
       
    }
}
