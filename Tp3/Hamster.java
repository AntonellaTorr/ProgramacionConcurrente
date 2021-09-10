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
        System.out.println(nombre+" en su run " );
        System.out.println(nombre+" por comenzar a comer " );
        try{
            Thread.sleep(1000);
            this.hamaca.usarHamaca();
        }catch(InterruptedException e){}
        this.comida.comer(20);
        System.out.println(nombre+" por comenzar a usar la hamaca " );
        System.out.println(nombre+" por comenzar a usar la rueda" );
        this.rueda.usarRueda();
    }
}
