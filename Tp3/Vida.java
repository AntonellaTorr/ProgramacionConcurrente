package Tp3;

public class Vida  {
    private int puntos= 10;

    public Vida (){}
    
    public int getPuntos(){
        return puntos;
     }
    public void añadirVida(int cantPuntos){
        puntos= puntos+cantPuntos;
    }
    
    public void quitarVida(int cantPuntos){
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){

        }
        puntos= puntos-cantPuntos;
    }
}
