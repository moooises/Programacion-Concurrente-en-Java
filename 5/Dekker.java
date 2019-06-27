/* Adaptado de M. Ben-Ari por Manuel Francisco */

/* Algoritmo de Dekker */
class Dekker {
    /* Iteraciones que dara cada hilo */
    static final int iteraciones = 2000000;
    /* Recurso compartido */
    static volatile int enteroCompartido = 0;
    /* Representa el deseo del hilo P de entrar en la seccion critica */
    static volatile boolean wantp = false;
    /* Representa el deseo del hilo Q de entrar en la seccion critica */  
    static volatile boolean wantq = false;
    /* Representa el deseo del hilo T de entrar en la seccion critica */  
    static volatile boolean wantt = true;
    /* Representa de quien es el turno */
    static volatile int turn = 1;

    class P extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantp = true;
                while (wantq==true || wantt==true) {
                    if (turn == 3||turn == 2) {
                        wantp = false;
                        while (turn == 3||turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                    System.out.println("Prueba1 "+i);
                }
                
                /* Seccion critica */
               ++enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 2;
                wantp = false;
            }
        }
    }
    
    class Q extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantq = true;
                while (wantp==true || wantt==true) {
                    if (turn == 1||turn == 3) {
                        wantq = false;
                        while (turn == 1||turn == 3)
                            Thread.yield();
                        wantq = true;
                    }
                        System.out.println("Prueba2 "+i);              
                }
                
                /* Seccion critica */
                --enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 3;
                wantq = false;
            }
        }
    }
    
    
        class T extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantt = true;
                while (wantp==true || wantq==true) {
                    if (turn == 1||turn == 2) {
                        wantt = false;
                        while (turn == 1||turn == 2)
                            Thread.yield();
                        wantt = true;
                    }
                                        System.out.println("Prueba3 "+i);
                }
                
                /* Seccion critica */
               System.out.println("Esta seccion critica no hace nada porque quiero que salga 0 :D");
                /* Fin Seccion critica */
                
                turn = 1;
                wantt = false;
            }
        }
    }

    Dekker() {
        Thread p = new P();
        Thread q = new Q();
        Thread t = new T();
        p.start();
        q.start();
        t.start();
        
        try {
            p.join();
            q.join();
            t.join();
            System.out.println("El valor del recurso compartido es " + enteroCompartido);
            System.out.println("Deberia ser 0.");
        }
        catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Dekker();
    }
}
