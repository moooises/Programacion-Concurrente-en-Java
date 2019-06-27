import java.util.Scanner;
import java.lang.Math;
import java.util.*;

/**
*El programa realizara una serie de operaciones sobre numeros complejos para 
*maximo dos numero
*En esta clase pedimos lo valores al usuario y los enviamos al constructor y 
*a los procedimientos de la clase Complejos
*Debemos mencionar que 
*@author Moises Guerero Lopez
*@version 1.0
*/

public class usaComplejos{
	
	
	public static void main(String[] args){
		
		/**
	*En la funcion main declaramos las variables, creamos el array de objetos
	*,pedimos los valores al usuario y creamos el menu
	*/
	
		int op=0,v1,v2;
		double real,imagin;
		double r1,r2,im1,im2;
	Scanner sc = new Scanner(System.in);
	System.out.println("Cuantos numeros complejos desea?");
	int n=sc.nextInt();
	ArrayList<Complejos> complejo= new ArrayList<Complejos>();
	//Complejos [] complejo = new Complejos [n];
	for(int i=0;i<n;++i){
		System.out.print("Introduce el valor real del complejo "+(i+1)+": ");
		real=sc.nextDouble();
		System.out.print("Introduce el valor imaginario del complejo "+(i+1)+" : ");
		System.out.println();
		imagin=sc.nextDouble();
		Complejos c=new Complejos(real,imagin);	
		complejo.add(c);
						}
	/**
	*Realizamos el menu y llamamos a los procedimientos pedido,preguntando 
	*previamente en que valores realizar la operacion
	*/
		do{
		System.out.println("-->Complejos seleccionables: 0 a "+complejo.size());
		System.out.println("Selecciona que operacion realizar: ");
		System.out.println("1 - Suma");
		System.out.println("2 - Resta");
		System.out.println("3 - Modulo");
		System.out.println("4 - Producto");
		System.out.println("5 - Cociente");
		System.out.println("0 - Salir");
		op=sc.nextInt();
	switch(op){

			case 1:
					System.out.println("Seleccion que complejo quiere sumar: ");
					v1=sc.nextInt();
					Complejos c1=complejo.get(v1);	
					System.out.println("Seleccione otro complejo: ");
					v2=sc.nextInt();
					Complejos c2=complejo.get(v2);	
					r2=c2.real;
					im2=c2.imag;
					c1.suma(r2,im2);
					System.out.println("\n");
					System.out.println("Desea realizar alguna operacion: ");
					break;
		
			case 2: System.out.println("Seleccion que complejo quiere restar: ");
					v1=sc.nextInt();
					Complejos c3=complejo.get(v1);	
					System.out.println("Seleccione otro complejo: ");
					v2=sc.nextInt();
					Complejos c4=complejo.get(v2);	
					r2=c4.real;
					im2=c4.imag;
					c3.resta(r2,im2);
					System.out.println("\n");
					System.out.println("Desea realizar alguna operacion: ");
					break;
			
			case 3:
					System.out.println("Seleccion de que complejo quiere el modulo: ");
					v1=sc.nextInt();
					Complejos c5=complejo.get(v1);	
					c5.modulo();
					System.out.println("\n");
					System.out.println("Desea realizar alguna operacion: ");
					break;
					
			case 4:
					System.out.println("Seleccion que complejo al que quiere realizar el producto: ");
					v1=sc.nextInt();
					Complejos c6=complejo.get(v1);	
					System.out.println("Seleccione otro complejo: ");
					v2=sc.nextInt();
					Complejos c7=complejo.get(v2);	
					r2=c7.real;
					im2=c7.imag;
					c6.producto(r2,im2);
					System.out.println("\n");
					System.out.println("Desea realizar alguna operacion: ");
					break;
			
			case 5:
				
					System.out.println("Seleccion que complejo al que quiere realizar el cociente: ");
					v1=sc.nextInt();
					Complejos c8=complejo.get(v1);	
					System.out.println("Seleccione otro complejo: ");
					v2=sc.nextInt();
					Complejos c9=complejo.get(v2);	
					r2=c9.real;
					im2=c9.imag;
					c9.cociente(r2,im2);
					System.out.println("\n");
					System.out.println("Desea realizar alguna operacion: ");
					break;
					
					
	default: break;
				}
		}while(op!=0);
	
	
										}
}