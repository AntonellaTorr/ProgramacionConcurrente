public class ControlTren implements Runnable {
    private Atraccion a;
    
    public ControlTren (Atraccion a){
        this.a=a;
    }
    public void run (){
        while (true){
            a.avisarTrenOcupacion();
        }
    }

}
