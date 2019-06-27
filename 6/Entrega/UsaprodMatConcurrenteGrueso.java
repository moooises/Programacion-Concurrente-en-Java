
/**
*@author Moises Guerrero Lopez
*@version 1.0
*@since Nombember 25, 2017
*@see  <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html"> </a>
*/
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class UsaprodMatConcurrenteGrueso implements Runnable{
		private static int filasA;
		private static int columnasA;
		private static int filasB;
		private static int columnasB;
		private static int A[][];
		private static int b[][];
		private static int y[][];
		private static int filaux;
		private static int inicio;
		private static int end;

		public UsaprodMatConcurrenteGrueso(){}
		public UsaprodMatConcurrenteGrueso(int [][]A,int[][] b,int[][]y,int f,int c,int e,int k,int inicio,int end){
		this.filasA=f;
		this.columnasA=c;
		this.filasB=e;
		this.columnasB=k;
		this.A=A;
		this.b=b;
		this.y=y;
		this.inicio=inicio;
		this.end=end;
											}

		public void run(){


		int aux;
		System.out.print("\n");
		for(int t=inicio;t<end;++t){//
			for(int i=0;i<columnasB;++i){
			aux=0;
				for(int j=0;j<columnasA;++j){
					aux=aux+((A[t][j])*(b[j][i]));//00x00 01x10 02x20 00x01 01x11 02x21 k es inicio
					y[t][i]=aux;
											}

					 //00 01 02
								}
									}

							}

	/**	public static int visualizar(int i,int j){
		return y[i][j];
														}*/

	public static void main(String[] args)
	 throws Exception {
		Random rd=new Random();
		Scanner sc = new Scanner(System.in);
		int op=0;
		int c=0,f=0,e=0,k=0;
		int filaux=0;;
		int inicio,end;
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

								}
							int nNuc = Runtime.getRuntime().availableProcessors();
							System.out.println("--------------"+nNuc);
							float Cb = Float.parseFloat(args[0]);
							System.out.println("--------------"+Cb);
							int tamPool = (int)(nNuc/(1-Cb));
							System.out.println("--------------"+tamPool);

							ExecutorService exec = Executors.newCachedThreadPool();
							filaux=f/tamPool;///
							end=filaux;
							inicio=0;
							for(int i=0;i<tamPool;++i){

								exec.execute(new UsaprodMatConcurrenteGrueso(A,b,y,f,c,e,k,inicio,end));
								inicio=end;
								//if(f%tamPool==0)filaux=filaux+filaux;
								if((f-end)<filaux){
									end=f;
											}

								else {
									filaux=filaux+filaux;
									end=filaux;
										}


														}

							exec.shutdown();
							while(!exec.isTerminated()){};

					for(int i=0;i<f;++i){
						for(int j=0;j<k;++j){
							System.out.print("["+y[i][j]+"]");
											}
							System.out.print("\n");
										}

							break;

		default: break;

		}

	}while(op!=3);

								}
}
