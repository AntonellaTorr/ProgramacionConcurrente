package Tp3;

public class Rueda {
    private int cantRuedas;
    public Rueda (){
        cantRuedas=4;
    }
    public static void usarRueda(){
        try {Thread.sleep(1000);}
        catch(InterruptedException e){}
        System.out.println ("Usando la rueda "+ Thread.currentThread().getName());
        

    }
    
}
