package Tp3;

public class Hamaca {
    private int largo;
    public Hamaca (){
        largo=10;
    }
    public synchronized static void usarHamaca (){
        System.out.println ("en la hamaca "+ Thread.currentThread().getName());
        System.out.println (Thread.currentThread().getName()+" termino de usar la hamaca");
    }
}
