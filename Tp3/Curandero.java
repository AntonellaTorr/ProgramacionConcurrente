package Tp3;

public class Curandero implements Runnable {
    private Vida vidaAtacar;
    public Curandero (Vida vidaAtacar){
        this.vidaAtacar=vidaAtacar;
    }
    
    public void run (){
        int i=0;
        while (i<5){
            //System.out.println ("Vida antes de curar "+vidaAtacar.getPuntos());
            vidaAtacar.añadirVida(3);
            //System.out.println ("Vida despues de curar "+vidaAtacar.getPuntos());
            i++;
        }
    }

}
