package Tp3;

public class SurtidorCombustible {
    private  static double cantLitrosTot=1000;

    
    public synchronized static void cargarCombustible(Auto auto, double cantLitros){
        auto.cargarNafta(cantLitros);
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){}

        cantLitrosTot-=cantLitros;

    }
    public double getCantLitros(){
        return cantLitrosTot;
    }

}
