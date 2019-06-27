/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.*;
import java.lang.Math.*;
import java.util.concurrent.*;
public class piunit implements Runnable{
	private int inicio;
	private int end;
	private static float aciertos;
	private static float cont;
	
	
	public piunit(){}
	public piunit(int inicio,int end){
		this.inicio=inicio;
		this.end=end;
													}
													
	public static float getciertos(){
					return aciertos;

							}
		/**
		*@override
		*/
	public void run(){

			Random rd = new Random();
			for(int i=inicio;i<end;++i){
			cont=0;
			double r=rd.nextDouble();
			//System.out.println("--"+r);
			double u=rd.nextDouble();
			//System.out.println("**"+u);
			synchronized(this){
			if(Math.pow(r, 2)+Math.pow(u, 2)<=1)++cont;
			aciertos=aciertos+cont;

								}

									}
						}
						
						
		public static void hilo(int inicio,int end,int gru,int tamPool,int n){
			int aux=0;
			aux=gru;
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i=0;i<tamPool;++i){
				exec.execute(new piunit(inicio,end));
				inicio=end;
			
				if(n-end<gru) end=n;
				else{
					aux=aux+gru;
					end=aux;
					}

										}
			exec.shutdown();
		try{
			
            exec.awaitTermination(5, TimeUnit.SECONDS);
        }catch(Exception e){}
        		
            }
		
													
		
	
	public static void main(String[] args)throws  InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos puntos quieres?");
		int end,inicio,n,gru,nNuc,tamPool;
		float cb,aciertos,res;
		long time_start, time_end;
		time_start = System.currentTimeMillis();
				aciertos=0;
						System.out.println("Indique cuantos numero quiere:");	
						n=6000000;
						nNuc = Runtime.getRuntime().availableProcessors();
						cb  = Float.parseFloat(args[0]);
						tamPool = (int)(nNuc/(1-cb));
		
						gru=n/tamPool;
						
						inicio=0;
		
						if(gru==0){
							tamPool=1;
							end=n;
									}
						else end=gru;
		
						hilo(inicio,end,gru,tamPool,n);
						aciertos=piunit.getciertos();
						res=(aciertos/n);
						System.out.println("El area de pi "+(4.0*aciertos/n)+"m^2");
						time_end = System.currentTimeMillis();
System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
						System.out.println("Desea realizar otra operacion:");
							
				
							
				
		
		
		
											}
}