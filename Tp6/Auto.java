package Tp6;

public class Auto  implements Runnable{
    private char direccionActual;
    private GestionaTrafico g;


    public Auto (char direccionActual, GestionaTrafico g){
        this.direccionActual=direccionActual;
        this.g=g;
    }
    public void run (){
        if (direccionActual== 'N'){
            g.entrarAutoDelNorte();
            pasar();
            g.salirAutoDelNorte();
        }else{
            g.entrarAutoDelSur();
            pasar();
            g.salirAutoDelSur();
        }
        
    }
    public void pasar (){
        try {
            System.out.println (Thread.currentThread().getName() +"pasando...");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
