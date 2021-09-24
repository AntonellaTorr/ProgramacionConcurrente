package Tp4.Ej11;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo (Comedor c){
        this.c=c;
    }
    public void run (){
        c.servirBebidas();
    }
}
