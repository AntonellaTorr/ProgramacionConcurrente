package Tp3;

public class Rueda {
    private int cantRuedas;
    public Rueda (){
        cantRuedas=4;
    }
    public synchronized static void usarRueda(){
     System.out.println ("Usando la rueda "+ Thread.currentThread().getName());
        

    }
    
}
