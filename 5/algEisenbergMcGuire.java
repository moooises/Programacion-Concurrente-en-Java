/**Algoritmo de Eisenber McGuire
 * @author  Mois�s Guerrero L�pez
 * @version 1.0
 * @since Nombember 18, 2017
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Random.html"> </a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/package-summary.html"> </a>
 */
import java.util.Random;
import java.util.concurrent.*;
class algEisenbergMcGuire implements Runnable{
	enum estado{IDLE, ESPERANDO, ACTIVO};
	static volatile estado [] flags = new estado[2];
	static volatile int turno;
	static volatile int indice;
	static volatile int enterocompartido=0;
	int selec;//Este indica si el hilo incrementa o disminuye
	int i;

	
		
		public algEisenbergMcGuire(int j,int selec){
		this.i=j;
		this.selec=selec;
												}
		/**
		 *		@Override  
		 */

		public void run(){
			int n=2;
		do{
			// announce that we need the resource 
			flags[i]=estado.ESPERANDO;
			// scan processes from the one with the turn up to ourselves. 
			// repeat if necessary until the scan finds all processes idle 
			indice=turno;
			
			while(indice!=i){
				if(flags[indice]!=estado.IDLE) indice=turno;
				else indice=(indice+1)%n;
				
							}
			//now tentatively claim the resource
			flags[i]=estado.ACTIVO;
			
			//find the first active process besides ourselves, if any
			indice=0;		
			while((indice < n) && ((indice==i) || (flags[indice]!=estado.ACTIVO))){
				indice=indice+1;	
																			}
			/** if there were no other active processes, AND if we have the turn
			or else whoever has it is idle, then proceed.  Otherwise, repeat
			the whole sequence. */
																				
			}while((indice < n) && ((turno!=i) || (flags[turno]!=estado.IDLE))); 
			
			//SC
				turno=i;
				if(selec==1){
					++enterocompartido;
						}
						else --enterocompartido;
		//SC fin
		
		// find a process which is not IDLE 
		// (if there are no others, we will find ourselves) 
		
		indice=(turno+1)%n;
		while(flags[indice]==estado.IDLE){
			indice=(indice+1)%n;
										}
		
		// give the turn to someone that needs it, or keep it 								
		turno=indice;
		
		// we're finished now 
		flags[i]=estado.IDLE;
		}
			
	public static void main(String[] args)throws InterruptedException {
		Random  rd = new Random();
		turno=rd.nextInt(1);
		flags[0]=estado.IDLE;	
		flags[1]=estado.IDLE;
		
		/**for(int i=0;i<hilos.length;++i){
		flags[i]=estado.IDLE;	
		}*/
		
			/**hilos[0]=new Thread(new algEisenbergMcGuire(0,0));
			hilos[1]=new Thread(new algEisenbergMcGuire(1,1));
			hilos[0].start();
			hilos[1].start();

										
										
		for(int i = 0; i<hilos.length;++i){
			hilos[i].join();
										}
										*/
		ExecutorService exec = Executors.newFixedThreadPool(2); //Thread [] hilos = new Thread[2];		
		exec.execute(new algEisenbergMcGuire(0,0));
		exec.execute(new algEisenbergMcGuire(1,1));
		exec.shutdown();

		exec.awaitTermination(1,TimeUnit.DAYS);								
										
										
		System.out.println("El entero compartido es : "+enterocompartido);
		System.out.println("Deberia ser 0");
										

										}
}