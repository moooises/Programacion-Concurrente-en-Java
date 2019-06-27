import java.util.Scanner;
import java.lang.Math.*;
class intDefinidaMonteCarlo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double r;
		double u;
		double cont;
		double res;
		int op;
		int n;
		do{
		System.out.println("Seleccione la funcion:");
		System.out.println("1 - f(x) = sin(x)");
		System.out.println("2 - f(x) = x");
		System.out.println("Pulse otro numero para salir");
		op=sc.nextInt();
		
		switch(op){
				case 1: cont=0;
						System.out.println("Indique cuantos numero quiere:");	
						n=sc.nextInt();
						for(int i=0;i<n;++i){
							r=Math.random();
							u=Math.random();
							if(u<Math.sin(r)){
								cont=cont+1;
												}
							}
							res=(cont/n);
							System.out.println("El area es "+res+"m^2");
							System.out.println("Desea realizar otra operacion:");
							break;
							
				case 2: cont=0;
						System.out.println("Indique cuantos numero quiere:");	
						n=sc.nextInt();
						for(int i=0;i<n;++i){
							r=Math.random();
							u=Math.random();
							if(u<r){
								cont=cont+1;
									}
							}
							res=(cont/n);
							System.out.println("El area es "+res+"m^2");
							System.out.println("Desea realizar otra operacion:");
							break;
							
				default: break;
				}
				
				
			}while(op==2 || op==1);
							
										}
}
		
