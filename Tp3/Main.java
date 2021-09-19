package Tp3;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {

        GestorTurno a= new GestorTurno(4);

        HiloLetra m= new HiloLetra(1,a,'A',1);
        HiloLetra b= new HiloLetra(1,a,'B',3);
        HiloLetra c= new HiloLetra(1,a,'C',2);
        HiloLetra d= new HiloLetra(1,a,'D',4);

        Thread hiloA= new Thread (m, "HiloA");
        Thread hiloB= new Thread (b, "HiloB");
        Thread hiloC= new Thread (c, "HiloC");
        Thread hiloD= new Thread (d, "HiloD");

        hiloA.start();
        hiloB.start();
        hiloC.start();
        hiloD.start();







        /*
        int [] arr=new int[50000];
        int i=0;
        while (i<50000){
            arr[i]=(int)Math.floor(Math.random() * 11);
            i++;         

        }
        System.out.println ("Ingrese la cantidad de hilos que desea crear");
        Scanner n= new Scanner(System.in);
        int cant= n.nextInt();
        HiloSumador [] arrRunnable= new HiloSumador [cant];
        int intervalo= 50000/cant;
       
        Thread [] arrHilos = new Thread [cant];

        crearRunnable(arr,arrRunnable, intervalo);
        crearEIniciarHilos(arrHilos, arrRunnable);

                
        for (int j=0;j<arrHilos.length;j++){
            try{
            arrHilos[j].join();
            }catch(InterruptedException e){} 
        }

        System.out.println ("Suma final segun los hilos "+calculoSumaHilos(arrRunnable));
        System.out.println ("Suma correcta "+calculoSumaCorrecta(arr));
       


    
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
        Thread Man = new Thread(vc, "Manuel");
        Luis.start();
        Man.start();
        
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
       

        System.out.println ("Valor final de la vida " +v.getPuntos());*/
        


        }
        public static void crearRunnable(int[] arreglo,HiloSumador [] arrRunnable, int intervalo){
            int l=0;
            int p=0;
            while(l<arrRunnable.length){
                arrRunnable[l]= new HiloSumador (arreglo,p,p+intervalo);
                l++;
                p+=intervalo;
                
            }
        }
    
        public static void crearEIniciarHilos(Thread []arrHilos, HiloSumador [] arrRunnable){
            int l=0;
            int m=0;
            while(l<arrHilos.length){
                arrHilos[l]=new Thread(arrRunnable[m]);
                l++;
                m++;
            }
            for (int j=0;j<arrHilos.length;j++){
                arrHilos[j].start();
            }
        }
        public static int calculoSumaCorrecta(int [] arr){
            int i=0;
            int suma=0;
            while (i<50000){
                suma=suma+arr[i];
                i++;
            }
            return suma;
        }
        public static int calculoSumaHilos(HiloSumador [] arrRunnable){
            int sumaFinal=0;
            int it=0;
            while (it<arrRunnable.length){
                sumaFinal+=arrRunnable[it].sumaParcial;
                it++;
            }
            return sumaFinal;
        }
}
