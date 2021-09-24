package Tp4.Ej11;

public class Empleado implements Runnable {
    private Comedor c;
    private String pedido;
    public Empleado (Comedor c, String p){
        this.c=c;
        this.pedido=p;
    }
    public void run (){
        if (this.pedido.equals("Comer")){
            c.solicitarComida();
        }
        else{
            if (this.pedido.equals("Tomar")){

            }else{
                
            }
        }
       
    }
}
