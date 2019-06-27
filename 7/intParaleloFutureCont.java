/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.*;
import java.lang.Math;
import java.util.concurrent.*;

public class intParaleloFutureCont implements Callable<Integer>{
	private int inicio;
	private int end;
	private int op;
	private int id;
	private static int n;
	private static float aciertos;



	public intParaleloFutureCont(int inicio,int end,int op,int id,int n){
		this.inicio=inicio;
		this.end=end;
		this.op=op;
		this.id=id;
		this.n=n;
	}

	/**
		*@override
		*@param cont
		*/
	public Integer call() throws Exception{
		synchronized(this){
			Integer cont=0;
			Random rd = new Random();

		for(int i=inicio;i<end;++i){
			float r=rd.nextInt();
			//System.out.println("--"+r);
			float u=rd.nextInt();
			//System.out.println("**"+u);
			if(op==1){
				if(u<Math.sin(r))cont++;
						}
			else if(op==2){
				if(u<r)cont++;
							}
				else System.out.println("ERROR XD");


									}


			System.out.println("Aciertos"+id+"="+cont);
			//System.out.println("Identificador="+id);

			return cont;
		}
						}

		public static void hilo(int inicio,int end,int gru,int tamPool,int n,int op,float aciertos,float res){
			int aux=0;
			int id=1;
			aux=gru;
			ExecutorService exec = Executors.newFixedThreadPool(tamPool);
			LinkedList<Future<intParaleloFutureCont>> resultList = new LinkedList<Future<intParaleloFutureCont>>();
			for(int i=0;i<tamPool;++i){
				//exec.execute(new intParalelomultiCont(inicio,end,op,id,n));
				Future<Integer> c =exec.submit(new intParaleloFutureCont(inicio,end,op,id,n));//-------cont
				try{
					aciertos=aciertos+c.get();
				}catch(ExecutionException e){

				}catch(InterruptedException e){}

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
        	int c=0;
        	res=(aciertos/n);
			System.out.println("El area es "+res+"m^2");

            }




	public static void main(String[] args)throws  InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos puntos quieres?");
		int end,inicio,n,gru,nNuc,tamPool,op=0;
		float cb,aciertos,res=0;
			long time_start, time_end;
		do{
		System.out.println("Seleccione la funcion:");
		System.out.println("1 - f(x) = sin(x)");
		System.out.println("2 - f(x) = x");
		System.out.println("Pulse otro numero para salir");
		op=sc.nextInt();

		switch(op){
				case 1: aciertos=0;
						System.out.println("Indique cuantos numero quiere:");
						n=sc.nextInt();
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

						hilo(inicio,end,gru,tamPool,n,op,aciertos,res);
						//System.out.println("Aciertos****="+aciertos);
						res=0;
						aciertos=0;
						System.out.println("Desea realizar otra operacion:");

						break;

				case 2: aciertos=0;
					time_start=0;
					time_end=0;
						System.out.println("Indique cuantos numero quiere:");
						n=sc.nextInt();
						time_start = System.currentTimeMillis();
						nNuc = Runtime.getRuntime().availableProcessors();
						cb  = Float.parseFloat(args[0]);
						tamPool = (int)(nNuc/(1-cb));

						gru=n/tamPool;
						inicio=0;

						if(gru<=0){
							tamPool=1;
							end=n;
									}
						else end=gru;

						hilo(inicio,end,gru,tamPool,n,op,aciertos,res);

						res=0;
						aciertos=0;
						System.out.println("Desea realizar otra operacion:");
 time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");


						break;


				default: break;
				}


			}while(op==2 || op==1);



											}
}
