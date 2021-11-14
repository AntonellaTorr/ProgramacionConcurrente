package Ej2;

public class Empaquetador implements Runnable {
    private Fabrica f;
    public Empaquetador (Fabrica f){
        this.f=f;
    }
    public void run (){
        while (true){
            f.empaquetar();
            try {
                System.out.println ("La caja se lleno, el empaquetador la toma, la sella y la almacena");
                Thread.sleep(100);
            } catch (Exception e) {
                
            }
            f.reponerCaja();
        }
        
      
    }
}
