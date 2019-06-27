
import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class piParalelo implements Runnable{
	private static Scanner sc= new Scanner(System.in);
	private static Random rd = new Random();
	private static double PI;
	private static int n;
	private static AtomicLong atomico= new AtomicLong(0);
	private int grueso;

	public piParalelo(int grueso){
		this.grueso=grueso;
								}
	public void run(){
	double x,y;
	for(int i=0;i<grueso;++i){
			x=rd.nextDouble();
			y=rd.nextDouble();
			if(Math.pow(x,2)+Math.pow(y,2)<=1){
				atomico.incrementAndGet();
												}
							}
		//System.out.println("Aciertos"+atomico.get());
					}



	public static void main(String[] args){
		//int nNuc= Runtime.getRuntime().availableProcessors();
		//float cb=Float.parseFloat(args[0]);
		int tamPool=Integer.parseInt(args[0]);
		System.out.println("Cuantos numero quiere lanzar?");
		n=Integer.parseInt(args[1]);
		long time_start, time_end;
		int numeros=n/tamPool;
		Thread []hilos= new Thread[tamPool];
		time_start = System.currentTimeMillis();
		//System.out.println("Numeros: "+numeros);
		int grueso=numeros;
			//ExecutorService exec = Executors.newCachedThreadPool();
			for(int i=0;i<tamPool;++i){
				hilos[i]= new Thread(new piParalelo(numeros));
				hilos[i].start();
			//System.out.println(i+" : "+grueso);
			//exec.execute(new piParalelo(numeros));
			if((grueso+numeros)>=n)numeros=n-grueso;
			else grueso+=numeros;

											}
			for(int i=0;i<tamPool;++i){
				try{
				hilos[i].join();
				}catch(Exception e){}
										}
			/**try{
			exec.shutdown();
			exec.awaitTermination(1, TimeUnit.DAYS);
			}catch(Exception e){}*/
		PI=4*((double)atomico.get()/(double)n);
		System.out.println("La aproximacion del numero PI por montecarlo es: "+PI);
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
							}
}
