/**
 * 
 * @author Moises Guerreo Lopez
 * @version 1.0
 *
 */
import java.rmi.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class CPiMonteCarlo extends Thread{
	
	private static iPiMonteCarlo ObjRemoto;
	private static Scanner sc = new Scanner(System.in);
	private static int id,reset,n;
	private static double aciertos,puntos;
	private static double r;
	
	
	public CPiMonteCarlo(){}
							
	public static void montecarlo(double puntos,int id,int reset,int n,double r){
		if(reset==1){
								try{
								ObjRemoto.reset();
								}catch(Exception e){}
								}
		else{
			try{
			ObjRemoto.aciertos(puntos,r);//pi/4 por r=1
			}catch(Exception e){}
			
				}
		reset=0;
						}

	public static void main(String[] args)throws Exception{
		double puntos=0;
		double PI;
		ObjRemoto= (iPiMonteCarlo) Naming.lookup("//localhost/Server");
		System.out.println("Cuantos clientes hay?");
		n=sc.nextInt();
		System.out.println("Cual es el radio de la circunferencia?");
		r=sc.nextDouble();
		for(int i=0;i<=n;++i){
			System.out.println("Quieres resetear la operacion?\n 1-Si \n 0-No");
			reset=sc.nextInt();
			if(reset==1 || i==n){
				PI=ObjRemoto.montecarlo();
				System.out.println("PI = "+PI);
							}
			else{
			System.out.println("Cuantos puntos quieres?");
			puntos=sc.nextInt();
				}
			montecarlo(puntos,id,reset,n,r);
				
							}
		
															}

							}