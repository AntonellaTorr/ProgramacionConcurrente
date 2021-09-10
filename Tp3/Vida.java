package Tp3;

public class Vida  {
    private int puntos= 100;

    public Vida (){}
    
    public synchronized int getPuntos(){
        return puntos;
     }
    public synchronized void añadirVida(int cantPuntos){
        puntos= puntos+cantPuntos;
    }
    
    public synchronized void quitarVida(int cantPuntos){
            puntos= puntos-cantPuntos;

    }
        
    
}
