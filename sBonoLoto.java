/**
 * 
 * @author Moises Guerreo Lopez
 * @version 1.0
 *
 */
 import java.rmi.*;
 import java.rmi.server.*;
 import java.rmi.registry.*;
 import java.net.*;
 import java.util.*;
  import java.util.Arrays;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto {
	
	private static Random rd = new Random();

	private static int [] bonoloto= new int[6];
	
	/**
	* 
	* @throws RemoteException 
	*/
	
	public sBonoLoto()throws RemoteException{
		super();
											}
													
	 public void resetServidor() throws RemoteException{
	 	 System.out.print("La combinacion ganadora de la bonoloto es: ");
	 	 
		for(int i=0;i<6;++i){
			bonoloto[i]=rd.nextInt(48)+1;
			System.out.print(""+bonoloto[i]+", ");
								}
		System.out.println("");
	 													}
	 /**
	 * @return true si los vectores son iguales, false si no
	 * @throws RemoteException
	 *
	 */
	
	public boolean compApuesta(int []apuesta)throws RemoteException{
		boolean respuesta;
		respuesta=Arrays.equals(apuesta,bonoloto);
		return respuesta;
																	}
																	
	public static void main(String[] args)throws Exception{
		
	
		
		sBonoLoto ObjRemoto = new sBonoLoto();
		
		Naming.bind("//localhost:2005/Server",ObjRemoto);
		
		System.out.println("Servidor Remoto Preparado");


											}
	
						}