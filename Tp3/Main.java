package Tp3;



public class Main {
    public static void main(String[] args) {

        int [] arr=new int[50000];
        int i=0;
        while (i<50000){
            arr[i]=1;
            i++;
           

        }
        //int arr[]={1,2,3,4,5,6,7,8,9,10};
        
        HiloSumador a= new HiloSumador(arr,0,9999);
        HiloSumador b= new HiloSumador(arr,10000,19999);
        HiloSumador c= new HiloSumador(arr,20000,29999);
        HiloSumador d= new HiloSumador(arr,30000,39999);
        HiloSumador e= new HiloSumador(arr,40000,49999);
        /*
        HiloSumador a= new HiloSumador(arr,0,1);
        HiloSumador b= new HiloSumador(arr,2,3);
        HiloSumador c= new HiloSumador(arr,4,5);
        HiloSumador d= new HiloSumador(arr,6,7);
        HiloSumador e= new HiloSumador(arr,8,9);
        */

        Thread hiloA= new Thread (a,"A");
        Thread hiloB= new Thread (b,"B");
        Thread hiloC= new Thread (c,"C");
        Thread hiloD= new Thread (d,"D");
        Thread hiloE= new Thread (e,"E");
        
        hiloA.start();
        hiloB.start();
        hiloC.start();
        hiloD.start();
        hiloE.start();

        try {
            hiloA.join();
            hiloB.join();
            hiloC.join();
            hiloD.join();
            hiloE.join();
        }catch(InterruptedException m){
             m.printStackTrace();
        }
        int sumaFinal= a.getSumaParcial()+b.getSumaParcial()+c.getSumaParcial()+d.getSumaParcial()+e.getSumaParcial();
        System.out.println ("Suma final segun los hilos "+sumaFinal);
        System.out.println ("Suma final correcta 50.000");







        /*
        SurtidorCombustible a= new SurtidorCombustible ();
        Auto a1= new Auto("000 ADC", "RMP", "Ford ", 3000,0,1000,a);
        Auto a2= new Auto("000 RRR", "UNIC", "Chevrolet ", 3000,0,1000,a);
        Auto a3= new Auto("000 MPR", "PEM", "Toyota ", 3000,0,1000,a);
        Auto a4= new Auto("000 QQQ", "TPM", "Renault ", 3000,0,1000,a);
        Auto a5= new Auto("000 FFF", "LLL", "Citroen", 3000,0,1000,a);

        Thread auto1= new Thread(a1,"Auto1");
        Thread auto2= new Thread(a2,"Auto2");
        Thread auto3= new Thread(a3,"Auto3");
        Thread auto4= new Thread(a4,"Auto4");
        Thread auto5= new Thread(a5,"Auto5");

        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
        try{
            auto1.join();
            auto2.join();
            auto3.join();
            auto4.join();
            auto5.join();
        }catch(InterruptedException e){}
           System.out.println ("Cant Litros en la estacion "+ a.getCantLitros());
        
        Object varC=new Object();
        HiloLetra a= new HiloLetra(1,varC, 'A');
        HiloLetra b= new HiloLetra(2,varC,'B');
        HiloLetra c= new HiloLetra(3,varC,'C');

        Thread hiloA= new Thread (a, "HiloA");
        Thread hiloB= new Thread (b, "HiloB");
        Thread hiloC= new Thread (c, "HiloC");

        
        PruebaHilosLetra.prueba(hiloA, hiloB, hiloC);

        int arr[]={1,0,0,1,0};// puede utilizar distintos valores para ver los cambios con otros valores.
        
        MiHilo mh1 = MiHilo.creaEInicia("#1",arr);
        MiHilo mh2 = MiHilo.creaEInicia("#2",arr);

        
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        }catch (InterruptedException exc){
        System.out.println("Hilo principal interrumpido.");
        }
       
        
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
