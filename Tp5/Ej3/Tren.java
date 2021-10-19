public class Tren implements Runnable{
    private Atraccion a;
    public Tren (Atraccion a){
        this.a=a;
    }

    public void run (){
        while (true){
            a.salir();
          
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            a.avisarLlegadaPasajeros();

        }
    }
}
