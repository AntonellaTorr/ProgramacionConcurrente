package Tp3;

public class Main {
    public static void main(String[] args) {
        /*VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
        */
        Vida v= new Vida ();
        Personaje orco= new Personaje("Orco",v);
        Personaje curandero= new Personaje("Curandero", v);
        Thread o= new Thread (orco);
        Thread c= new Thread(curandero);
        o.start();
        c.start();
       try{
            o.join();
            c.join();
       } catch (InterruptedException e){
       }
        System.out.println (v.getPuntos());
        


        }
}
