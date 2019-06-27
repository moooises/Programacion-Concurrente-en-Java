/**
*@author Moises Guerrero Lopez
*@version 1.0
*@since Nombember 25, 2017
*/
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class resImagenParFin implements Runnable{
	private int fila;
	private int dim;
	private static int [][]Imagen;
	private static int [][]Resaltado;

	//Constructor nulo
	public resImagenParFin(){}

	public resImagenParFin(int fila,int dim,int [][]Imagen,int [][]Resaltado){
		this.fila=fila;
		this.dim=dim;
		this.Imagen=Imagen;
		this.Resaltado=Resaltado;
									}
	//@override
	 public void run(){
	for(int j=1;j<(dim+1);++j){
		Resaltado[fila][j]=((4*(Imagen[fila][j])-Imagen[fila+1][j]-Imagen[fila][j+1]-Imagen[fila-1][j]-Imagen[fila][j-1])/8);

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
	Scanner sc= new Scanner(System.in);
	System.out.println("Seleccione la dimension de la matriz");
	int n=sc.nextInt();//


	int Imagen[][]=new int[n+2][n+2];
	int Resaltado[][]=new int[n+2][n+2];

	iniciarIm(Imagen,n);
	visualizarIm(Imagen,n);


	//ExecutorService exec= Executors.newFixedThreadPool(n);
	Thread []hilos=new Thread[n];
	for(int i=0;i<n;++i){
	hilos[i]=new Thread(new resImagenParFin(i+1,n,Imagen,Resaltado));
	hilos[i].start();
	}

	for(int i=0;i<n;++i){
	//exec.shutdown();
	try{
	hilos[i].join();
	}catch(InterruptedException e){}
	}


	visualizarRe(Resaltado,n);



	/**System.out.println("EL resaltado en la imagen sera:");
	for(int i=1;i<n;++i){
		for(int j=1;j<n;++j){
			System.out.print("["+Resaltado[i][j]+"]");
							}
			System.out.println("\n");

						}*/
											}

}
