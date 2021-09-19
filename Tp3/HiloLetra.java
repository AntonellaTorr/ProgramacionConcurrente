package Tp3;

public class HiloLetra implements Runnable {
    private char letra;
    private int cantImpresiones;
    private int turno;
    private GestorTurno gestor;

    
    public HiloLetra (int cant,GestorTurno gestor, char letra,int turno){
        this.cantImpresiones=cant;
        this.gestor=gestor;
        this.letra=letra;
        this.turno=turno;
    }
    public void run (){
        int cantExito=0;
        while (cantExito<3){
            if (this.gestor.getTurno()==turno){
                imprimir();
                cantExito++;
                this.gestor.siguienteTurno();
            }
            else{ 
                try{Thread.sleep(10);}catch(InterruptedException e){}
            }
        }
    
    }
    
        
    
    public void imprimir(){
        for (int i=0;i<cantImpresiones;i++){
            System.out.print(letra);
            
        }
   } 

    
}