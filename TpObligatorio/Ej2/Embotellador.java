package Ej2;

public class Embotellador implements Runnable {
    private Fabrica f;
    
    public Embotellador (Fabrica f){
        this.f=f;
    }
    public void run (){
 
        while (true){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            f.embotellar();

        }
    }
}
