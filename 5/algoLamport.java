/**Algoritmo de Lamport
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 18, 2017
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Random.html"> </a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html"> </a>
 */
import java.util.Scanner;
import java.util.concurrent.*;

class algoLamport implements Runnable{
	static volatile int[]numero;
	static volatile boolean[]eligiendo;
	int i;
	static volatile int n;
	static volatile int enterocompartido;
	static volatile boolean permiso;
	
	public algoLamport(int i,boolean permiso){
		this.i=i;
		this.permiso=permiso;
								}
	
	//@override
	public void run(){
		while(permiso){
		// Calcula el número de turno 	
		eligiendo[i]=true;
		numero[i]=max()+1;//hacer maximo
		eligiendo[i]=false;
		
		// Compara con todos los hilos 
		for(int j=0;j<n;++j){
			// Si el hilo j está calculando su número, espera a que termine 
			while(eligiendo[j]){/**nada aqui*/}
			/** Si el hilo j tiene más prioridad, espera a que ponga su número a cero 
                j tiene más prioridad si su número de turno es más bajo que el de i,  
                o bien si es el mismo número y además j es menor que i               */
			while((numero[j]!=0) && ((numero[j]<numero[i])||((numero[j]==numero[i])&&(j<i)))){/**nada aqui*/}//ojo muchos parentesis
							}
		//SC
			++enterocompartido;
		//fin SC
		System.out.println("Cliente nº "+enterocompartido);
		numero[i]=0;
		permiso=false;
							}
	}
	/**
	 *Devuelve el maximo de un vector
	 *@return max Mayor valor del vector	
	 */
	public static int max(){
		int max=0;
		for(int i=0;i<n;++i){
			if(numero[i]>max){
				max=numero[i];
								}
			else ++i;
							}
		return max;
	}
	
	public static void main(String[] argts)throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos hilos desea?");
		n=sc.nextInt();
		numero=new int[n];
		eligiendo=new boolean[n];
		
		for(int i=0;i<n;++i){
			numero[i]=0;
			eligiendo[i]=false;
							}
							
		/**Thread hilos[]=new Thread[n];
		
		for(int i=0;i<n;++i){
			hilos[i]=new Thread(new algoLamport(i,true));
			hilos[i].start();
							}
							
		for(int i=0;i<n;++i){
			hilos[i].join();
							}*/
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<n;++i){
			exec.execute(new algoLamport(i,true));
							}
		exec.shutdown();

		exec.awaitTermination(1,TimeUnit.DAYS);			
														
		System.out.println("El numero de clientes totales ha sido : "+enterocompartido);
		if(enterocompartido!=n)System.out.println("A ocurrido un fallo");
	
										}
							
		
}