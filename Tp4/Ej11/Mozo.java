package Tp4.Ej11;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo (Comedor c){
        this.c=c;
    }
    public void run (){
        while (true){
            c.comenzarAPrepararBebida();
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){}
            c.servirBebida();
        }
        
    }
}
