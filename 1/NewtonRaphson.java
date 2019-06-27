import java.util.Scanner;
import java.lang.Math.*;
class NewtonRaphson{
	static double aprox1(double i){
		return i-((Math.cos(i)-Math.pow(i,3))/(-Math.sin(i)-3*Math.pow(i,2)));
						}
	static double aprox2(double i){
		return i-((Math.pow(i,2)-5)/(2*i));
									}
	
	public static void main (String [] args){
	Scanner sc = new Scanner(System.in);
	int op;
	int cont;
	double i;
	int n;
	do{
		
			System.out.println("Eliga que funcion quiere:");
			System.out.println("1 -  f(x) = cos(x) - x^3 en [0; 1]");
			System.out.println("2 - f(x) = x^2 - 5 en [2; 3]");
			System.out.println("3 - Salir");
			op=sc.nextInt();
		
		
		
		switch(op){
				case 1:	cont=0;
						
					do{
						System.out.println("Indique el valor inicial entre [0,1]: ");
						i = sc.nextDouble();
					}while(i<0 || i>1);
						System.out.println("Indique el numero de iteraciones a realizar: ");
						n = sc.nextInt();
						do{
						System.out.println("La apriximacion numero "+(cont)+" es "+i);
						i=aprox1(i);
						cont++;
						}while(cont!=n+1);
						break;
						
				case 2: cont=0;
						
					do{
						System.out.println("Indique el valor inicial entre [2,3]: ");
						i = sc.nextDouble();
					}while(i<2 || i>3);
						System.out.println("Indique el numero de iteraciones a realizar: ");
						n = sc.nextInt();
						do{
						System.out.println("La apriximacion numero "+(cont)+" es "+i);
						i=aprox2(i);
						cont++;
						}while(cont!=n+1);
						break;
						
					
					}
	}while(op!=3);
											}


}