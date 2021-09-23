package Tp4.Ej5;

public class CentroImpresion {
    private int numA;
    private int numB;
    private static Impresora a=new Impresora("A"); ;
    private static Impresora b=new Impresora("B");;


    public CentroImpresion (int numA, int numB){
        this.numA=numA;
        this.numB=numB;
        int i=0;
        

        /*
        this.a= new Impresora [numA];
        this.b= new Impresora [numB];
        while(i<numA){
            this.a[i]= new Impresora("A");
            i++;
        }
        i=0;
        while(i<numB){
            this.b[i]= new Impresora("B");
            i++;
        }
        */
        
        
     }
    public static void imprimir (String tipo,String texto){
        if (tipo.equals("A")){
            a.imprimir("A");
        }
        else{
            b.imprimir("B");
        }
    }
    
}
