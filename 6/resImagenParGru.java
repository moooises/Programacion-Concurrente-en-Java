/*
@author Moises Guerrero Lopez
@version 1.0
*/
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class resImagenParGru implements Runnable{
	private int dim;
	private static int [][]Imagen;
	private static int [][]Resaltado;
	private int inicio;
	private int end;
	//Constructor nulo
	public resImagenParGru(){}
	
	public resImagenParGru(/** */int dim,int [][]Imagen,int [][]Resaltado,int inicio,int end){
	//	this.fila=fila;
		this.dim=dim;
		this.Imagen=Imagen;
		this.Resaltado=Resaltado;
		this.inicio=inicio;
		this.end=end;
									}
	//@override								
	 public void run(){
	 for(int t=inicio;t<=end;++t){
	for(int j=1;j<(dim+1);++j){
		Resaltado[t][j]=((4*(Imagen[t][j])-Imagen[t+1][j]-Imagen[t][j+1]-Imagen[t-1][j]-Imagen[t][j-1])/8);
	

	//	System.out.println(""+Resaltado[f][j]);
								}
	 }
	
	}
		
	
	static void iniciarIm(int [][]Imagen,int n){
	Random rd= new Random();
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			Imagen[i][j]=rd.nextInt(21);
							}
						}
						
	for(int i=0;i<=n+1;++i){
			Imagen[0][i]=0;
			Imagen[n][0]=0;	
						 }
							
	for(int i = 0;i<=n+1;++i){
		Imagen[i][0]=0;
		Imagen[0][n]=0;
							} 
								}
								
	static void visualizarIm(int [][]Imagen,int n){
		System.out.println("La imagen introducida es: ");
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			System.out.print("["+Imagen[i][j]+"]");
							}
			System.out.println("\n");

						}
									System.out.println("\n");
			System.out.println("\n");

									}
									
	static void visualizarRe(int [][]Resaltado,int n){
	System.out.println("EL resaltado en la imagen sera:");
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			System.out.print("["+Resaltado[i][j]+"]");
							}
			System.out.println("\n");

						}
									}
									
									
	/**void resaltado(int[][]Imagen,float [][]Resaltado){
		for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			Resaltado[i][j]=((4*(Imagen[i][j])-Imagen[i+1][j]-Imagen[i][j+1]-Imagen[i-1][j]-Imagen[i][j-1])/8);
							}
						}
						
				System.out.println("\n");
			System.out.println("\n");
														}*/

	public static void main(String[] args){
	double time_start=0,time_end=0;
	Scanner sc= new Scanner(System.in);
	System.out.println("Seleccione la dimension de la matriz");
	int n=sc.nextInt();//
	time_start = System.currentTimeMillis();
	int filaux,inicio,end;

	
	int Imagen[][]=new int[n+2][n+2];
	int Resaltado[][]=new int[n+2][n+2];
	
	iniciarIm(Imagen,n);
	visualizarIm(Imagen,n);
	
		int nNuc = Runtime.getRuntime().availableProcessors();
		System.out.println("--------------"+nNuc);
		float Cb = Float.parseFloat(args[0]);
		System.out.println("--------------"+Cb);
		int tamPool = (int)(nNuc/(1-Cb));
		System.out.println("--------------"+tamPool);
							
		int numeros=n/tamPool;///
																							//System.out.println("*******"+numeros);

		if(numeros==0){
			tamPool=1;
			end=n;//
						}
		else end=numeros;
		inicio=1;
		filaux=numeros;
	//ExecutorService exec= Executors.newFixedThreadPool(n);
	Thread []hilos=new Thread[tamPool];
	for(int i=0;i<tamPool;++i){
	hilos[i]=new Thread((new resImagenParGru(n,Imagen,Resaltado,inicio,end)));
	hilos[i].start();
	inicio=end+1;
	
	if((n-end)<filaux){
		end=n;
						}
											
	else {
		filaux=filaux+numeros;
		end=filaux;
		}
	}
	
	for(int i=1;i<tamPool;++i){					
	//exec.shutdown();
	try{
	hilos[i].join();
	}catch(InterruptedException e){}
	}
	
	
	visualizarRe(Resaltado,n);	
			
	time_end = System.currentTimeMillis();
	System.out.println("the task has taken "+(time_end - time_start)+" milliseconds");
	double speedup=120/(time_end - time_start);
	System.out.println("El speed up es "+speedup+" ms");

	/**System.out.println("EL resaltado en la imagen sera:");
	for(int i=1;i<n;++i){
		for(int j=1;j<n;++j){
			System.out.print("["+Resaltado[i][j]+"]");
							}
			System.out.println("\n");

						}*/
											}
	
}