package Tp4.Ej5;

import java.util.concurrent.Semaphore;

public class CentroImpresion {
    private int numA;
    private int numB;
    private Impresora [] impresorasA;
    private Impresora [] impresorasB;



    public CentroImpresion (int numA, int numB){
        this.numA=numA;
        this.numB=numB;
        this.impresorasA= new Impresora[numA];

        this.impresorasB= new Impresora[numB];
        for (int i=0;i<numA;i++){
            impresorasA[i]= new Impresora("A","Desocupada");
        }
        for (int j=0;j<numB;j++){
            impresorasB[j]= new Impresora("B","Desocupada");
        }
    }

    public Impresora buscarImpresoraLibre(String tipo){
        Impresora impresoraLibre=null;
        Impresora [] arrayImp;
        int i=0;
        if (tipo.equals("B")){
            while (impresoraLibre==null&& i<numB){
                if (impresorasB[i].getEstado().equals("Desocupada")){
                    impresoraLibre=impresorasB[i];
                }
                i++;
            }
        }
        else{
            
            arrayImp=impresorasA;
        }
       
        return impresoraLibre;
    }
    
    public synchronized void imprimir (String cadena, String tipoImpresion){
        Impresora imp=buscarImpresoraLibre(tipoImpresion);
        if (imp==null){
            if (tipoImpresion.equals("A")){
                
            }
        }
        imp.imprimir(cadena);
    }

    
}
