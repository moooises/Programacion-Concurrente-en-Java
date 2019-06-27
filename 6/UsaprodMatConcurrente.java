import java.util.Random;
import java.util.Scanner;
public class UsaprodMatConcurrente{

	public static void main(String[] args)
	 throws Exception {
		Random rd=new Random();
		Scanner sc = new Scanner(System.in);
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
				f = sc.nextInt();
				System.out.println("Introduce el numero de columnas de la matriz A:");
				c=sc.nextInt();
				System.out.println("Introduce el numero de filas del vector B :");
				e=sc.nextInt();
				System.out.println("Introduce el numero de columnas del vector B :");
				k=sc.nextInt();
				if(e!=c){
						System.out.println("No se puede realizar el producto");
						}
				break;
		case 2:	
			if(c==0 || f==0 || e==0 || k==0)System.out.println("No es posible multiplicar");
			else{
				
			int A[][]=new int[f][c];
			int b[][]=new int[e][k];
			int y[][]=new int[f][k];
				System.out.println("La Matriz A es: \n");
					for(int i=0;i<f;++i){
						for(int j=0;j<c;++j){
							A[i][j]=rd.nextInt();
							System.out.print("["+A[i][j]+"]");
											}
											System.out.print("\n");
										}  
										System.out.println("\n");

				System.out.println("La Matriz b es: \n");
					for(int i=0;i<e;++i){
						for(int j=0;j<k;++j){
							b[i][j]=rd.nextInt();
							System.out.print("["+b[i][j]+"]");
												}
								System.out.print("\n");
			
							}
							System.out.println("\n");
										
								prodMatConcurrente [] hilos=new prodMatConcurrente[f];
								for(int i=0;i<f;++i){
								hilos[i]=new prodMatConcurrente(A,b,y,f,c,e,k,i);
								hilos[i].start();
													}
							
								for(int i=0;i<f;++i){
									hilos[i].join();
													}
					for(int i=0;i<f;++i){
						for(int j=0;j<k;++j){
							System.out.print("["+prodMatConcurrente.visualizar(i,j)+"]");
											}
							System.out.print("\n");

											
				
			}
			}
			break;
			
		default: break;
		
		}
		
	}while(op!=3);
							
								}
}