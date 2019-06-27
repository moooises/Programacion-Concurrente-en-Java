import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class vectorgrueso implements Runnable{
		Semaphore semaforo = new Semaphore(1);
		private static int filasA;
		private static int columnas;
		private static int A[][];
		private static int b[][];
		private static int y[][];
		private int inicio;
		private int end;
		
		public vectorgrueso(){}
		public vectorgrueso(int [][]A,int[][] b,int[][]y,int f,int c,int inicio,int end){
		this.filasA=f;
		this.columnas=c;
		this.A=A;
		this.b=b;
		this.y=y;
		this.inicio=inicio;
		this.end=end;
											}
	

											
	public void run(){ 
		
		
		//int aux;
		for(int i=inicio;i<end;++i){
			System.out.println("inicio////////////"+inicio);
			y[inicio][0]=0;					
										System.out.println("end////////////"+end);
		//aux=0;
		for(int j=0;j<columnas;++j){
			y[inicio][0]=y[inicio][0]+(A[inicio][j]*b[j][0]);
									}
				System.out.println("-["+y[inicio][0]+"]\n");
			
				}		
			
			}
						
																		
	public static void main(String[] args)throws Exception{
		Random rd=new Random();
		Scanner sc = new Scanner(System.in);
		int op=0;
		int c=0,f=0,e=0,inicio,end;
		int filaux;
		do{
		System.out.println("Que desea realizar?\n");
		System.out.println("1-Seleccionar dimesiones");
		System.out.println("2-Rellenar vector y multiplicar");
		System.out.println("3-Salir");
		op=sc.nextInt();
		switch(op){
			
			
		case 1: System.out.println("Introduce el numero de columnas de la matriz A:");
				c = sc.nextInt();
				System.out.println("Introduce el numero de filas de la matriz A:");
				f=sc.nextInt();
				System.out.println("Introduce el numero de filas del vector :");
				e=sc.nextInt();
				if(e!=c){
						System.out.println("No se puede realizar el producto");
						}
				break;
		case 2:	
			if(c==0 || f==0 || e==0)System.out.println("No es posible multiplicar");
			else{
				
	int A[][]=new int[f][c];
	int b[][]=new int[c][1];
	int y[][]=new int[e][1];
				for(int i=0;i<f;++i){
					for(int j=0;j<c;++j){
						A[i][j]=rd.nextInt(5);
							System.out.print("[----"+A[i][j]+"]");
											}
							System.out.print("\n");
	
									}
									
									for(int i=0;i<c;++i){
										b[i][0]=rd.nextInt(5);	
			System.out.println("["+b[i][0]+"]\n");
														}
										
							int nNuc = Runtime.getRuntime().availableProcessors();
							System.out.println("--------------"+nNuc);
							float Cb = Float.parseFloat(args[0]);
							System.out.println("--------------"+Cb);
							int tamPool = (int)(nNuc/(1-Cb));
							System.out.println("--------------"+tamPool);
							int cont=0;
							ExecutorService exec = Executors.newCachedThreadPool();
							int numeros=f/tamPool;///
																							//System.out.println("*******"+numeros);

							if(numeros==0){
								tamPool=0;
								end=f;
							}
							else end=numeros;
							inicio=0;
							filaux=numeros;
							for(int i=0;i<tamPool;++i){
							//	System.out.println("1!!!!!!!!!!"+inicio);
							//	System.out.println("1!!!!!!!!!!"+end);
								exec.execute(new vectorgrueso(A,b,y,f,c,inicio,end));
								cont++;
																							//	System.out.println("Vez numero"+cont);

								inicio=end;
								//if(f%tamPool==0)filaux=filaux+filaux;
								
								if((f-end)<filaux){
									end=f;

											}
											
								else {
									filaux=filaux+numeros;
									end=filaux;
										}
																					//System.out.println("2!!!!!!!!!!"+inicio);

																								//System.out.println("2!!!!!!!!"+end);

														}
														
							exec.shutdown();
							while(!exec.isTerminated()){};
								
			for(int i=0;i<c;++i){

							System.out.print("["+y[i][0]+"]");
											}
							System.out.print("\n");
										
			
							break;
			}
			
		default: break;
		}
	}while(op!=3);
							
	
											}
}