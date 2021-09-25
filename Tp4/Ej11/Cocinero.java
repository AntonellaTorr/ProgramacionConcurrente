package Tp4.Ej11;

public class Cocinero implements Runnable {
    private Comedor c;

    public Cocinero(Comedor c){
        this.c=c;
    }

    public void run (){
        while (true){
            c.comenzarAPrepararComida();
            System.out.println ("El cocinero comienza a preparar la comida");
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){}
            c.servirComida();
        }
    }
    
}
