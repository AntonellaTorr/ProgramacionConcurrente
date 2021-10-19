public class Main {
    public static void main(String[] args) {
        Instrucciones in= new Instrucciones (2,3,4);
        Thread [] proc= new Thread[4];
        for (int i=0;i<proc.length;i++){
            proc[i]= new Thread( new Proceso((i+1),in));
        }
        for (int i=0;i<proc.length;i++){
            proc[i].start();
        }

    }
}
