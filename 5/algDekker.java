/**Algoritmo de Dekker para 3 procesos
 * @author  Mois�s Guerrero L�pez
 * @version 1.0
 * @since Nombember 18, 2017
 */
class algDekker {
    /* Iteraciones que dara cada hilo */
    static final int iteraciones = 2000000;
    /* Recurso compartido */
    static volatile int enteroCompartido = 0;
    /* Representa el deseo del hilo P de entrar en la seccion critica */
    static volatile boolean wantp = false;
    /* Representa el deseo del hilo Q de entrar en la seccion critica */  
    static volatile boolean wantq = false;
    /* Representa el deseo del hilo T de entrar en la seccion critica */  
    static volatile boolean wantt = false;
    /* Representa de quien es el turno */
    static volatile int turn = 1;

    class P extends Thread {
            //@override 
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantp = true;
                if(wantq){
                while (wantq) {
                    if (turn == 2) {
                        wantp = false;
                        while (turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                  turn=3;
                }
                		}
                		
                if(wantt){
                	while (wantt) {
                    if (turn == 3) {
                        wantp = false;
                        while (turn == 3)
                            Thread.yield();
                        wantp = true;
                    }
                   turn=1;
                }
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
     //@override 
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantq = true;
                
                if(wantt){
                while (wantt) {
                    if (turn == 3) {
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantq = true;
                    }
                       turn=1;
                }
                			}
                			
                if(wantp){
                	 while (wantp) {
                    if (turn == 1) {
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantq = true;
                    }
                       turn=2;
                }
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
        //@override 
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
               
                wantt = true;
                if(wantt){
                	
                while (wantp) {
                    if (turn == 1) {
                        wantt = false;
                        while (turn == 1)
                            Thread.yield();
                        wantt = true;
                    }
                                       turn=2;
                }
                			}
               
               if(wantq){
               	while (wantp) {
                    if (turn == 2) {
                        wantt = false;
                        while (turn == 2)
                            Thread.yield();
                        wantt = true;
                    }
                    
                                        turn=3;
                }   
               }
                
                /* Seccion critica */
               ++enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 1;
                wantt = false;
            }
        }
    }

    algDekker() {
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
        new algDekker();
    }
}
