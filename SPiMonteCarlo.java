/**
 * 
 * @author Moises Guerreo Lopez
 * @version 1.0
 *
 */
import java.rmi.Naming;
import java.rmi.server.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.lang.Math.*;
import java.util.*;

public class SPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo{
	private static Random rd = new Random();										
	private static double aciertos;
	private static double n;
	
	/**
	* 
	* @throws RemoteException 
	*/
	public SPiMonteCarlo() throws RemoteException{
		super();
												}
												
	public void reset(){
		this.aciertos=0;
		this.n=0;
				}
					
	public void aciertos(double numeros,double r){
		double x,y;
		int in=0;
	
		for(int i=0;i<numeros;++i){
			x=rd.nextDouble()*r;//*r pero el radio es 1 porque es un cuadrado de 1x1
			//System.out.println("X= "+x);
			y=rd.nextDouble()*r;
			//System.out.println("Y= "+y);
			if(Math.pow(x,2)+Math.pow(y,2)<=r){
				++in;
												}
							}
		aciertos=aciertos+in;
		System.out.println("Aciertos: "+aciertos);
			n=n+numeros;
		System.out.println("Numero totales: "+n);
										}
	/**
	* @return la estimacion del numero PI
	*
	*/
	public double montecarlo(){
		double pi=(4*(aciertos/n));
		return pi;
						}
												
	
	public static void main(String [] args)throws Exception{
		
		SPiMonteCarlo ObjRemoto= new SPiMonteCarlo();
		Naming.bind("Server",ObjRemoto);
		System.out.println("Servidor listo");
												}
							}