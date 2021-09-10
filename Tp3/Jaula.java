package Tp3;

public class Jaula {
    private Comida comida;
    private Rueda  rueda;
    private Hamaca hamaca;

    public Jaula (){
        Comida comida= new Comida ();
        Rueda rueda= new Rueda ();
        Hamaca hamaca= new Hamaca();
    }
    public synchronized void comerCantidad(int cantidad){
        Comida.comer(cantidad);
    }
    public synchronized void usarRueda(){
        Rueda.usarRueda();

    }
    public synchronized void usarHamaca (){
        Hamaca.usarHamaca();
    }
    
}
