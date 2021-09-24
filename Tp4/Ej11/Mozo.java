package Tp4.Ej10;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo (Comedor c){
        this.c=c;
    }
    public void run (){
        c.servirComida();
    }
}
