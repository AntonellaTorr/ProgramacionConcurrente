package PracticaParcial.EjAutos;

public class Auto implements Runnable {
    private static GestorCruce g= new GestorCruce ();
    private String lado;

    public Auto (String lado){
        this.lado=lado;
    }
    
    public void run (){
        if (lado.equals("Norte")){
            System.out.println (Thread.currentThread().getName() +" llego a la entrada norte");
            g.llegaNorte();
            //simula que esta pasando
            try {
                Thread.sleep(100);
            } catch (Exception e) {  }
            g.salePorLadoSur();
         
        }
        else{
            System.out.println (Thread.currentThread().getName() +" llego a la entrada oeste");
            g.llegaOeste();
            //simula que esta pasando
            try {
                Thread.sleep(100);
            } catch (Exception e) {  }
            g.salePorLadoEste();

        }
    }
}
