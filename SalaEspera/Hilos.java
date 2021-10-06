package SalaEspera;

public class Hilos extends Thread {

    public Hilos (){}
    private RecCompartido c= new RecCompartido();
    public Hilos (RecCompartido c){
        this.c=c;
    }
    public void run (){
        c.intentarIngresar();  
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            //TODO: handle exception
        }   
        c.irse();

    }
}
