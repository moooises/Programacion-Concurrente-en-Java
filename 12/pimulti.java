/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.*;
import java.lang.Math.*;
import java.util.concurrent.*;
public class pimulti implements Runnable{
	private int inicio;
	private int end;
	//private static volatile float aciertos;
	private int id;
	private static int n;
	private static volatile float aciertos;
	
	
	public pimulti(){}
	public pimulti(int inicio,int end,int id,int n){
		this.inicio=inicio;
		this.end=end;
		this.id=id;
		this.n=n;
													}
													
	public static float getciertos(){
					return aciertos;

							}
			/**
		*@override
		*/										
	public void run(){
		
			float cont=0;
			Random rd = new Random();

		for(int i=inicio;i<end;++i){
			double r=rd.nextDouble();
			//System.out.println("--"+r);
			double u=rd.nextDouble();
			//System.out.println("**"+u);
			
			 if(Math.pow(r, 2)+Math.pow(u, 2)<=1)cont++;
			

									}
				synchronized(this){
				if(id==1)aciertos=cont;
				else aciertos=aciertos+cont;
				}
									
			

		
						}
						
		public static void hilo(int inicio,int end,int gru,int tamPool,int n){
			int aux=0;
			int id=1;
			aux=gru;
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i=0;i<tamPool;++i){
				exec.execute(new pimulti(inicio,end,id,n));
				inicio=end;
			
				if(n-end<gru) end=n;
				else{
					aux=aux+gru;
					end=aux;
					}
			++id;
										}
			exec.shutdown();
		try{
			
            exec.awaitTermination(5, TimeUnit.SECONDS);
        }catch(Exception e){}

            }
		
													
		
	
	public static void main(String[] args)throws  InterruptedException{
		int end,inicio,n,gru,nNuc,tamPool,op=0;
		float cb,aciertos,res;
		long time_start, time_end;
time_start = System.currentTimeMillis();


		

						
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
						aciertos=pimulti.getciertos();

time_end = System.currentTimeMillis();
System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
						System.out.println("El area de pi "+(4.0*aciertos/n)+"m^2");
						
							
					
		
		
											}
}