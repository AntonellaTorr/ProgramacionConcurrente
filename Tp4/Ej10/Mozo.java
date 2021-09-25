package Tp4.Ej10;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo (Comedor c){
        this.c=c;
    }
    public void run (){
        while (true){
            System.out.println ("Inventando recetas");
            c.comenzarAPrepararComida();
            System.out.println ("El mozo comienza a preparar la comida");
            //agregar sleep
            c.servirComida();
        }
    }
}
