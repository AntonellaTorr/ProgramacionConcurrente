package Tp3;

public class Main {
    public static void main(String[] args) {
        int arr[]={1,0,0,1,0};// puede utilizar distintos valores para ver los cambios con otros valores.
        MiHilo mh1 = MiHilo.creaEInicia("#1",arr);
        MiHilo mh2 = MiHilo.creaEInicia("#2",arr);
        /* try {
            mh1.hilo.join();
            mh2.hilo.join();
        }catch (InterruptedException exc){}*/
        


        /*
        Comida comida= new Comida ();
        Rueda rueda= new Rueda ();
        Hamaca hamaca= new Hamaca();

        Hamster Juan= new Hamster("Juan", comida,rueda,hamaca);
        Hamster Pepe= new Hamster("Pepe", comida,rueda,hamaca);
        Hamster Manuel= new Hamster("Manuel",comida,rueda,hamaca);
        Thread J= new Thread (Juan, "Juan");
        Thread P= new Thread (Pepe,"Pepe");
        Thread M= new Thread (Manuel,"Manuel");

        J.start();
        P.start();
        M.start();
 

        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    
        Vida v= new Vida ();
        Orco orco= new Orco(v);
        Curandero curan= new Curandero(v);
        Thread o= new Thread (orco);
        Thread c= new Thread (curan);
        o.start();
        c.start();
        try{
            o.join();
            c.join();
        }catch (InterruptedException e){

        }
       

        System.out.println ("Valor final de la vida " +v.getPuntos());
        
        */
        


        }
}
