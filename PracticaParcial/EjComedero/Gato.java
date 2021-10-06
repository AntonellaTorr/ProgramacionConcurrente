package PracticaParcial.EjComedero;

public class Gato implements Runnable{
    private  Comedor c;
    public Gato (Comedor c){
        this.c=c;
    }
    public void run (){
        c.gatoEntrarAComer();
        try {
            //simula que come
            Thread.sleep(100);
        } catch (Exception e) {}
        c.saleDeComerGato();
    }
}
