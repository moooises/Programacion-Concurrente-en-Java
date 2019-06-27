/**
*@author Moises Guerrero Lopez
*@version 1.0
*@since November 30,2017
*/

import java.util.*;
import java.lang.Math.*;
import java.util.concurrent.*;
public class intParalelauniCont implements Runnable{
	private int inicio;
	private int end;
	private static volatile float aciertos;
	private int op;
	private int id;


	public intParalelauniCont(){}
	public intParalelauniCont(int inicio,int end,int op,int id){
		this.inicio=inicio;
		this.end=end;
		this.op=op;
		this.id=id;
													}

	public static float getciertos(){
					return aciertos;

							}
			/**
		*@override
		*/
	public void run(){
		synchronized(this){
			Random rd = new Random();

		for(int i=inicio;i<end;++i){
			float r=rd.nextInt();
			//System.out.println("--"+r);
			float u=rd.nextInt();
			//System.out.println("**"+u);
			if(op==1){
				if(u<Math.sin(r))aciertos++;
						}
			else if(op==2){
				if(u<r)aciertos++;
							}
				else System.out.println("Ha habido un fallo");


									}

			//System.out.println("Aciertos="+aciertos);
			//System.out.println("Identificador="+id);


		}
						}

		public static void hilo(int inicio,int end,int gru,int tamPool,int n,int op){

			int aux=0;
			int id=1;
			aux=gru;
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i=0;i<tamPool;++i){
				exec.execute(new intParalelauniCont(inicio,end,op,id));
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos puntos quieres?");
		int end,inicio,n,gru,nNuc,tamPool,op=0;
		float cb,aciertos,res;
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

						hilo(inicio,end,gru,tamPool,n,op);
						aciertos=intParalelauniCont.getciertos();
						//System.out.println("Aciertos****="+aciertos);
						res=(aciertos/n);
						System.out.println("El area es "+res+"m^2");
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

						if(gru==0){
							tamPool=1;
							end=n;
									}
						else end=gru;

						hilo(inicio,end,gru,tamPool,n,op);
						aciertos=intParalelauniCont.getciertos();
						//System.out.println("Aciertos****="+aciertos);
						res=(aciertos/n);
						System.out.println("El area es "+res+"m^2");
						System.out.println("Desea realizar otra operacion:");

							 time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
						aciertos=0;
						break;


				default: break;
				}


			}while(op==2 || op==1);



											}
}
