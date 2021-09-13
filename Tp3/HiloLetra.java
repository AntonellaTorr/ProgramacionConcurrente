package Tp3;

public class HiloLetra implements Runnable {
    private char letra;
    private int cantImpresiones;
    private Object varCompartida;
    private boolean esMiTurno;
    public HiloLetra (int cant, Object varC, char letra,boolean miTurno){
        this.cantImpresiones=cant;
        this.varCompartida=varC;
        this.letra=letra;
        this.esMiTurno=miTurno;
    }
    public void run (){
        while (esMiTurno){        
            imprimir(varCompartida);
        }
        
    }
    public void imprimir(Object varC){
        synchronized (varCompartida){
            for (int i=0;i<cantImpresiones;i++){
                System.out.print(letra);
                if (i==cantImpresiones-1){
                   esMiTurno=false;
                }
            }
        }
            
        
    }

    
}
