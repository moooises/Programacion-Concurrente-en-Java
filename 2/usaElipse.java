import java.util.*;
/**
*Este programa nos indicara si una serie de puntos dados por el usuario se 
*encuentra dentro o sobre una elipse en la que hemos definido su centro,
*eje mayor y eje menor
*	@author Moises Guerero Lopez

*/
public class usaElipse{
	
	public static void main(String[] args){
		
		/**
		*En la calse principal creamos la varaibles necesarias, pedimos valores
		*al usuario y tambien realizamos el contructor
		*/
		boolean r;
		int ejex,ejey,n=0;
		double ejemayor,ejemenor,px,py;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el eje menor de la elipse: ");
		ejemenor=sc.nextDouble();
		System.out.println("Introduzca el eje mayor de la elipse");
		ejemayor=sc.nextDouble();
		System.out.println("Introduzca el eje X del centro: ");
		ejex=sc.nextInt();
		System.out.println("Introduzca el eje Y del centro: ");
		ejey=sc.nextInt();
		Elipse elipse = new Elipse(ejemenor,ejemayor,ejex,ejey);
		
		/**
		*Menu 
		*/
		do{
			System.out.println("Introduzca los puntos que quiere comprobar: ");
			System.out.println("Punto x");
			px=sc.nextDouble();
			System.out.println("Punto Y");
			py=sc.nextDouble();
			r=elipse.dentro(ejemenor,ejemayor,ejex,ejey,px,py);
				if(r)System.out.println("Esta dentro a la elipse");
				else System.out.println("No esta dentro a la elipse");
				System.out.println("Deseas realizar otra comprobacion: ");
				System.out.println("0 - NO");
				System.out.println("1 - Si");
				n=sc.nextInt();
		
		}while(n!=0);
		
		
		
		
											}

}