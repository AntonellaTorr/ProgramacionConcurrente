package Tp3;

public class Comida {
    private static int cantidad;

    public Comida (){
        cantidad=100;
    }   
    public synchronized static void comer(int cant){
        System.out.println ("Comiendo" +Thread.currentThread().getName());
        try {Thread.sleep(1000);}
        catch(InterruptedException e){}
        cantidad= cantidad-cant;
        System.out.println ( "cantidad de comida que dejo "+Thread.currentThread().getName()+ ": "+ cantidad);
        
    }
}
