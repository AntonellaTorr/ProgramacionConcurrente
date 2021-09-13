package Tp3;

public class Vida  {
    private int puntos= 100;

    public Vida (){}
    
    public int getPuntos(){
        return puntos;
     }
    public void añadirVida(int cantPuntos){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){};
        puntos= puntos+cantPuntos;
       
    }
    
    public  void quitarVida(int cantPuntos){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){};
        puntos= puntos-cantPuntos;


    }
        
    
}
