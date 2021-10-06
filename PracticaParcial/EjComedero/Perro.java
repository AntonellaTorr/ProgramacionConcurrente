package PracticaParcial.EjComedero;


public class Perro implements Runnable{
    private  Comedor c;
    
    public Perro (Comedor c){
        this.c=c;
    }
    public void run (){
        c.perroEntrarAComer();
        try {
            //simula que come
            Thread.sleep(100);
        } catch (Exception e) {}
        c.saleDeComerPerro();
    }
}
