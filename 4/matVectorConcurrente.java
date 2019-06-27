import java.util.Scanner;
import java.util.Random;
import java.lang.*;
public class matVectorConcurrente implements Runnable{
	private static int filas;
	private static int columnas;
	private static int A[][];
	private static int b[][];
	private static int y[][];
	private int filaux;
	
	
	public matVectorConcurrente(int [][]A,int[][] b,int[][]y,int f,int c,int aux){
		this.filas=f;
		this.columnas=c;
		this.A=A;
		this.b=b;
		this.y=y;
		this.filaux=aux;
											}
							
	public void run(){ 
		int aux=0;
	
		
		for(int j=0;j<columnas;++j){
			aux=aux+(A[filaux][j]*b[j][0]);
									}
			y[filaux][0]=aux;
			System.out.println("["+y[filaux][0]+"]\n");
									
			}
									
																		
	public static void main(String[] args)throws Exception{
		Random rd=new Random();
		Scanner sc = new Scanner(System.in);
		long time_start, time_end;
		int pr=10000;
		int op=0;
		int c=0,f=0,e=0;
		
		do{
		System.out.println("Que desea realizar?\n");
		System.out.println("1-Seleccionar dimesiones");
		System.out.println("2-Rellenar vector y multiplicar");
		System.out.println("3-Salir");
		op=sc.nextInt();
		switch(op){
			
			
		case 1: System.out.println("Introduce el numero de columnas de la matriz A:");
				c =pr;
				System.out.println("Introduce el numero de filas de la matriz A:");
				f=pr;
				System.out.println("Introduce el numero de filas del vector :");
				e=pr;
				if(e!=c){
						System.out.println("No se puede realizar el producto");
						}
				break;
		case 2:	
			if(c==0 || f==0 || e==0)System.out.println("No es posible multiplicar");
			else{
				
				time_start = System.currentTimeMillis();
				int A[][]=new int[f][c];
				int b[][]=new int[c][1];
				int y[][]=new int[e][1];
					for(int i=0;i<f;++i){
						for(int j=0;j<c;++j){
							A[i][j]=rd.nextInt(10000);
											}
									}
									
						for(int i=0;i<c;++i){
							b[i][0]=rd.nextInt(10000);	
												}
								Thread[]hilos=new Thread[f];
										for(int i=0;i<f;++i){
											hilos[i]=new Thread(new matVectorConcurrente(A,b,y,f,c,i));
											hilos[i].start();
															}
							
										for(int i=0;i<f;++i){
											hilos[i].join();
															}
				}
				time_end = System.currentTimeMillis();
				System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
				break;
			
		default: break;
		}
	}while(op!=3);
							
	//	matVectorConcurrente(f,c);
	/**	for(int i=0;i<f;++i){
			for(int j=0;j<c;++j){
				r=rd.nextInt();
				inicializarA(i,j,r);
								}
							}
							
		for(int i=0;i<c;++i){
			r=rs.nextInt();
			inicializarb(i,r);
							}
				*/
											}
}