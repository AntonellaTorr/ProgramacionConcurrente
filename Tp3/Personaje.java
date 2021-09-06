package Tp3;

public class Personaje implements Runnable {
    private String nombre;
    private Vida vidaAModificar;

    public Personaje (String nombre, Vida vidaAModificar){
        this.nombre=nombre;
        this.vidaAModificar=vidaAModificar;
    }
    public void run (){
        if (nombre.equals("Orco")){
           // System.out.println ("Vida antes de quitar "+vidaAModificar);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        vidaAModificar.quitarVida(3);

        }else{
            vidaAModificar.añadirVida(3);
        }
       
    }
}
