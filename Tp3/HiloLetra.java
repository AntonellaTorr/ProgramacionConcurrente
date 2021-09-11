package Tp3;

public class HiloLetra implements Runnable {
    private char letra;
    private int cantImpresiones;
    private Object varCompartida;
    public HiloLetra (int cant, Object varC, char letra){
        this.cantImpresiones=cant;
        this.varCompartida=varC;
        this.letra=letra;
    }
    public void run (){
        synchronized(varCompartida){
            for (int i=0;i<cantImpresiones;i++){
                System.out.print(letra);
            }
        }
    }

    
}
