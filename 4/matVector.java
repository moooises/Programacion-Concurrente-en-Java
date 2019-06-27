import java.util.Scanner;
import java.util.Random;
public class matVector{
	
	public static void inicializar(int [][]A,int [][]b,int c,int f){
		Random rd=new Random();
		System.out.println("La Matriz A es: \n");
		for(int i=0;i<f;++i){
			for(int j=0;j<c;++j){
				A[i][j]=rd.nextInt();
				System.out.print("["+A[i][j]+"]");
								}
				System.out.println("\n");
							}  
							
		System.out.println("La Matriz b es: \n");
		for(int i=0;i<f;++i){
			b[i][0]=rd.nextInt();
			System.out.println("["+b[i][0]+"]");
							}
		System.out.println("\n");

															}
															
	public static void multiplicar(int[][]A,int[][]b,int[][]y,int c,int f){
		int aux;
		int p=0;
		for(int i=0;i<f;++i){
			aux=0;
			for(int j=0;j<c;++j){
				aux=aux+((A[i][j])*(b[j][0]));
				
								}
				y[p][0]=aux;
				++p;
				
							}
																	}
																	
	public static void visualizar(int[][]y,int c){
		System.out.println("La Matriz y es: \n");
		for(int i=0;i<c;++i){
			System.out.println("["+y[i][0]+"]");
							}
											}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long time_start, time_end;

		int op=0;
		int c=0,f=0,e=0;
		int pr=10000;
		do{
		System.out.println("Que desea realizar?\n");
		System.out.println("1-Seleccionar dimesiones");
		System.out.println("2-Rellenar vector y multiplicar");
		System.out.println("3-Salir");
		op=sc.nextInt();
			switch(op){
				
		case 1: System.out.println("Introduce el numero de columnas de la matriz:");
				c =pr;
				System.out.println("Introduce el numero de filas de la matriz:");
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
				int[][]A=new int [f][c];
				int[][]b=new int [c][1];
				int[][]y=new int [c][1];
				time_start = System.currentTimeMillis();
				inicializar(A,b,c,f);
				multiplicar(A,b,y,c,f);
				visualizar(y,c);
				time_end = System.currentTimeMillis();
				System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
											
											break;
			}
			
			
		default: break;
		}
	}while(op!=3);
		
	
	}
	
}