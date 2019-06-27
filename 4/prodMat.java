import java.util.Scanner;
import java.util.Random;
public class prodMat{
	
	public static void inicializar(int [][]A,int [][]b,int c,int f,int e,int k){
		Random rd=new Random();
		System.out.println("La Matriz A es: \n");
		for(int i=0;i<f;++i){
			for(int j=0;j<c;++j){
				A[i][j]=rd.nextInt(10);
				System.out.print("["+A[i][j]+"]");
								}
				System.out.print("\n");
							}  
				System.out.println("\n");

		System.out.println("La Matriz b es: \n");
		for(int i=0;i<e;++i){
			for(int j=0;j<k;++j){
			b[i][j]=rd.nextInt(10);
			System.out.print("["+b[i][j]+"]");
								}
		System.out.print("\n");
			
							}
		System.out.println("\n");

															}
															
	public static void multiplicar(int[][]A,int[][]b,int[][]y,int c,int f,int k){
		int aux;
		for(int i=0;i<f;++i){
			for(int j=0;j<k;j++){
			aux=0;
			for(int n=0;n<c;++n){
				aux=aux+((A[i][n])*(b[n][j]));
				
								}
			y[i][j]=aux;
			}
				
				
				
							}
																	}
																	
	public static void visualizar(int[][]y,int f,int k){
		System.out.println("La Matriz y es: \n");
		for(int i=0;i<f;++i){
			for(int j=0;j<k;++j){
			System.out.print("["+y[i][j]+"]");
								}
			System.out.print("\n");
							}
														}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long time_start, time_end;
		int pr=10000;
		int op=0;
		int c=0,f=0,e=0,k=0;
		
		do{
		System.out.println("Que desea realizar?\n");
		System.out.println("1-Seleccionar dimesiones");
		System.out.println("2-Rellenar vector y multiplicar");
		System.out.println("3-Salir");
		op=sc.nextInt();
			switch(op){
				
		case 1: System.out.println("Introduce el numero de filas de la matriz A:");
				f=pr;
				System.out.println("Introduce el numero de columnas de la matriz A:");
				c=pr;
				System.out.println("Introduce el numero de filas de la matriz B :");
				e=pr;
				System.out.println("Introduce el numero de columnas de la matriz B :");
				k=pr;

				if(e!=c ){
						System.out.println("No se puede realizar el producto");
						}
				break;
		case 2:
			if(c==0 || f==0 || e==0 || k==0)System.out.println("No es posible multiplicar");
			else{
				time_start = System.currentTimeMillis();
				int[][]A=new int [f][c];
				int[][]b=new int [e][k];
				int[][]y=new int [f][k];
				inicializar(A,b,c,f,e,k);
				multiplicar(A,b,y,c,f,k);
				visualizar(y,f,k);
			}
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
			break;
			
		default: break;
		}
	}while(op!=3);
		
											}
	
	
}