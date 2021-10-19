import java.util.concurrent.Semaphore;

public class Instrucciones {
    private int a,b,c,w,x,y,z;
    Semaphore sem1_3, sem2_3, sem3_4;
    public Instrucciones (int x, int y, int z){
        sem1_3= new Semaphore (0);
        sem2_3= new Semaphore (0);
        sem3_4= new Semaphore (0);
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public void resolver (int tipo){
        switch(tipo){
            case 1:
                    resolverS1();
            break;
            case 2:
                    resolverS2();
            break;
            case 3: 
                    resolverS3();
            break;
            case 4: 
                    resolverS4();
            break;
        }
    }
    private void resolverS1(){
        a=x+y;
        System.out.println ("Resultado de x+y " +a);
        sem1_3.release();
   }
   private void resolverS2 (){
        b=z-1;
        System.out.println ("Resultado de z-1 " +b);
        sem2_3.release();
    }
    private void resolverS3 (){
        try {
            sem1_3.acquire();
            sem2_3.acquire();
            c=a-b;
            System.out.println ("Resultado de a-b " +c);
            sem3_4.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void resolverS4 (){
        try {
            sem3_4.acquire();
            w=c+1;
            System.out.println ("Resultado de c+1 " +w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
