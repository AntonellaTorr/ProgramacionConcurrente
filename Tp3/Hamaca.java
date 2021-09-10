package Tp3;

public class Hamaca {
    private int largo;
    public Hamaca (){
        largo=10;
    }
    public static void usarHamaca (){
        System.out.println ("en la hamaca "+ Thread.currentThread().getName());
        try {Thread.sleep(1000);}
        catch(InterruptedException e){}
        System.out.println (Thread.currentThread().getName()+" termino de usar la hamaca");
    }
}
