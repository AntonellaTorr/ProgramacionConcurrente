package Tp3;

public class Hamster implements Runnable {
    private String nombre;
    private Comida comida;
    private Rueda  rueda;
    private Hamaca hamaca;

    public Hamster (String nombre,Comida comida, Rueda rueda, Hamaca hamaca){
        this.nombre=nombre;
        this.comida= comida;
        this.rueda=rueda;
        this.hamaca=hamaca;
    }
    public void run () {    
        Hamaca.usarHamaca();
        Comida.comer(20);
        Rueda.usarRueda();
    }
}
