package Ej1;
public class Proceso  implements Runnable{
    private int tipo;
    private Instrucciones i;

    public Proceso(int tipo, Instrucciones i){
        this.tipo=tipo;
        this.i=i;
    }
    public void run (){
        i.resolver(tipo);
    }

}
