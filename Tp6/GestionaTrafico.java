package Tp6;

public class GestionaTrafico {
    private char pasando;
    private int cantPasando, cantEsperando;

    public GestionaTrafico (){
        cantEsperando=0;
        cantPasando=0;
        pasando='S';
    }
    public synchronized void entrarAutoDelNorte (){
        if (pasando== 'N'){

            cantPasando++;
        }else{
            System.out.println (Thread.currentThread().getName() +" llega pero no puede pasar");
            cantEsperando++;
            while (pasando!= 'N'){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println (Thread.currentThread().getName() +" logra pasar");
            cantPasando++;
            cantEsperando--;
        }
    }
    public synchronized void entrarAutoDelSur (){
        if (pasando== 'S'){
            cantPasando++;
        }else{
            System.out.println (Thread.currentThread().getName() +" llega pero no puede pasar");
            cantEsperando++;
            while (pasando!= 'S'){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println (Thread.currentThread().getName() +" logra pasar");
            cantPasando++;
            cantEsperando--;
        }
    }
    public synchronized void salirAutoDelNorte (){
        if (cantPasando==1){
            cantPasando--;
            pasando='S';
            this.notifyAll();
        }
        else{
            cantPasando--;
        }
        System.out.println (Thread.currentThread().getName() +" se va");
    }
    public synchronized void salirAutoDelSur(){
        if (cantPasando==1){
            cantPasando--;
            pasando='N';
            this.notifyAll();
        }
        else{
            cantPasando--;
        }
        System.out.println (Thread.currentThread().getName() +" se va");
    }
}
