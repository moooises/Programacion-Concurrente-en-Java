import java.util.Scanner;

/**
*En esta programa creamos la funcion recursiva para la funcion de Ackermann
*aunque no sale como lo esperabamos
*@author Moises Guerrero López
*@version 1.0
*/
class Ack{
	
	/**
	*Funcion recursiva para Ackermann
	*@param Devuelve un entero con valores pequeños y el error StackOverFlow para valores altos
	*/
	public static int Acker(int m,int n){
		if(m==0) return ++n;
		else{
			if(n==0)return Acker(--m,1);
			else return Acker(m-1,Acker(m,--n));
			}
										}
	/**
	*En la funcion principal pedimos los valores para la funcion al usuario
	*/
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int res;
		//System.out.println("Escribe un valor m para la funcion de Ackermann: ");
		int m=Integer.parseInt(args[0]);
		System.out.println("m: "+args[0]);
		//System.out.println("Escribe el valor n para la funcion de Ackermann :");
		int n=Integer.parseInt(args[1]);
		System.out.println("n: "+args[1]);
		res=Acker(m,n);
		System.out.println("El resultado es: "+res);
		
											}
}