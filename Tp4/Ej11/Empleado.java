package Tp4.Ej11;

public class Empleado implements Runnable {
    private Comedor c;
    private String pedido;
    public Empleado (Comedor c, String pedido){
        this.c=c;
        this.pedido=pedido;
    }
    public void run (){
        c.ingresarAlComedor();//MUTEX
        System.out.println (Thread.currentThread().getName()+ "  llego al comedor");
        if (pedido.equals("Comida")){
            c.solicitarComida();
            c.esperarComida();
            System.out.println (Thread.currentThread().getName()+" esta comiendo");
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){}
        }
        else{
            if (pedido.equals("Bebida")){
                c.solicitarBebida();
                c.esperarBebida();
                System.out.println (Thread.currentThread().getName()+ "esta tomando su bebida");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}
            }
            else{
                c.solicitarBebida();
                c.esperarBebida();
                System.out.println (Thread.currentThread().getName()+ " esta tomando su bebida");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}
                c.solicitarComida();
                c.esperarComida();
                System.out.println (Thread.currentThread().getName()+" esta comiendo");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}

            }
        }
        c.irseDelComedor();
        System.out.println (Thread.currentThread().getName()+" abandona el comedor");
       
    }
}
