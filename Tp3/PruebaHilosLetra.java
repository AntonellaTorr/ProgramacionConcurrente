package Tp3;

public  class PruebaHilosLetra {

    public static void prueba ( ){
        Object varC=new Object();
        HiloLetra a= new HiloLetra(1,varC, 'A',true);
        HiloLetra b= new HiloLetra(2,varC,'B',false);
        HiloLetra c= new HiloLetra(3,varC,'C',false);

        Thread hiloA= new Thread (a, "HiloA");
        Thread hiloB= new Thread (b, "HiloB");
        Thread hiloC= new Thread (c, "HiloC");

        hiloA.start();
        
        
        
        
    }
    
}
