import java.util.*;
import java.lang.Math;

/**
*En esta clase construimos la parte real e imaginaria de los numeros complejos
*y tambien realizamos las operaciones mediamte procedimientos a los que enviamos 
*los parametros desde la clase usaComplejos
*@author Moises Guerrero Lopez
*@version 1.0
*/

class Complejos{
double real;
double imag;
	/**
	Constructor nulo
	*/
		public Complejos(){}
		
	/**
	Constructor
	*/
		public Complejos(double r,double im){
			real=r;
			imag=im;
									}
									
		/**
		Procedimiento de la suma
		*/
		public void suma(double r2,double im2){
		System.out.print("La suma es: "+(real+r2));
		if((imag+im2)>=0) System.out.print("+"+(imag+im2)+" i");
		else System.out.print(""+(imag+im2)+" i");
																	}
																									
		/**
		Procedimiento de la resta
		*/
	public void resta(double r2,double im2){
		System.out.print("La resta es: "+(real-r2));
		if((imag+im2)>=0) System.out.print("+"+(imag+im2)+"i");
		else System.out.print(""+(imag+im2)+" i");
																	}
																						
		/**
		Procedimiento del modulo
		*/			
	public void modulo(){
		System.out.println("El modulo es: "+Math.sqrt(real*real+imag*imag));
																	}
																	
		/**
		Procedimiento del producto
		*/							
	public void producto(double r2,double im2){
		System.out.print("El producto es: "+(real*r2-imag*im2));
		if((real*im2+r2*imag)>=0) System.out.print("+"+(imag+im2)+" i");
		else System.out.print(""+(imag+im2)+" i");
														}
									
		/**
		Procedimiento del cociente
		*/
	public void cociente(double r2,double im2){
		System.out.print("El producto es: "+(real*r2+imag*im2)+"/"+(r2*r2+im2*im2));
		if((r2*imag-real*im2)>=0) System.out.print("+"+(r2*imag-real*im2)+"/"+(r2*r2+im2*im2)+" i");
		else System.out.print(""+(r2*imag-real*im2)+"/"+(r2*r2+im2*im2)+" i");
																			}
	
	
																	
}