package SalaEspera;

public class Hilos extends Thread {
    private char tipo;

    public Hilos (){}
    private RecCompartido c= new RecCompartido();
    public Hilos (RecCompartido c, char tipo){
        this.c=c;
        this.tipo=tipo;
    }
    public void run (){
        if (tipo=='A'){
            c.intentarIngresarA();
            this.ocuparSilla();
            c.irseA();
        }
        else{
            c.intentarIngresarB();
            this.ocuparSilla();
            c.irseB();

        }
         
       

    }
    public void ocuparSilla (){
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            //TODO: handle exception
        }  
    }
}
