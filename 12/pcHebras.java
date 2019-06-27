import java.util.*;
import java.util.concurrent.*;
//Modificar, cambiar a threadpool y separar el productor del consumidor
class pcHebras implements Runnable{

	private static int n,aciertos;
	private static double PI;
	private static Scanner sc = new Scanner(System.in);
	private static pcMonitor monitor new pcMonitor(100);


	public pcHebras(int n){
		this.n=n;
											}

	public void run(){

		if(n%2)producir();
		else consumir();

			}

	void producir(){
			monitor.insertar();//tienes que cambiar el monitor

						}

	 void consumir(){

			if(monitor.extraer()<=1)++aciertos;

						}

	public static void main(String[] args){
		long time_start, time_end;
		System.out.println("Cuantas inserciones y extracciones quieres?");
		int n=sc.nextInt();
		time_start = System.currentTimeMillis();
		//ThreadPoolExecutor pool = new ThreadPoolExecutor(4,4,0L,TimeUnit MILLISECONDS,new LinkedBlockingQueue<Runnable>());//cambiar el 4 para hacer el speedup
		Thread []hilos= new Thread[n];//cambiar
		for(int i=0;i<n*2;++i){
		//pool.execute(new Thread(new pcHebras(i)));
		hilos[i]= new Thread(new pcHebras(i));
		hilos[i].start();
							}

		for(int i=0;i<n*2;++i){
				hilos[i].join();
		}

		/**pool.shutdown();
				try{
						pool.awaitTermination(2, TimeUnit.SECONDS);
				}catch(Exception ex){}*/
	//	System.out.println("Aciertos= "+aciertos+"\nNumeros= "+(5*n));
		PI=(4*((double)(aciertos)/(double)(n*5)));
		System.out.println("La aproximacion del numero PI es "+PI);
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
										}


				}
