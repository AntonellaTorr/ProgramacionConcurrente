package Tp5.Ej4;

public class Avion implements Runnable {
    //accion define que quiere hacer el avion si aterrizar o despegar
    private String accion;
    private Pista p;

    public Avion (String accion,Pista p){
        this.accion=accion;
        this.p=p;
    }
    public void run (){

    }
    public void aterrizar(){
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void despegar(){
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
