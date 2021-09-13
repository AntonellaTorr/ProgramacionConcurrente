package Tp3;

public class Orco implements Runnable {
    private Vida vidaAtacar;
    public Orco (Vida vidaAtacar){
        this.vidaAtacar= vidaAtacar;
    }
    public void run (){
        int i=0;
        while (i<5){
            System.out.println ("Vida antes de atacar "+vidaAtacar.getPuntos());
            vidaAtacar.quitarVida(3);
            System.out.println ("Vida despues de atacar "+vidaAtacar.getPuntos());
            
            i++;
        }
    }
}
