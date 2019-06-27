
/**
 * 
 * @author Moises Guerreo Lopez
 * @version 1.0
 *
 */
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;

public class cBonoLoto extends Thread{
	private static iBonoLoto ObjRemoto;
	private int []apuesta=new int[6];
	private final Lock cerrojo = new ReentrantLock();
	private static Random rd = new Random();

	/**
	 * 
	 * @return true si la apuesta es igual al bonoloto, false si no
	 * @throws Exception
	 */
	public boolean Comprobar_apuesta()throws Exception{
		boolean respuesta=false;
		ObjRemoto.resetServidor();
		for(int i=0;i<6;++i){
			apuesta[i]=rd.nextInt();
			
								}
		
		if(ObjRemoto.compApuesta(apuesta))respuesta=true;
		return respuesta;
										}				
	
	public void run(){
	cerrojo.lock();
		try{
		if(Comprobar_apuesta())System.out.println("Enhorabuena, has ganado");
		else System.out.println("Perdiste, mas suerte la proxima vez");
	}catch(Exception e){	
		
	}finally{cerrojo.unlock();}
	
						}

	
	public static void main(String[] args) throws Exception{
	
		
		ObjRemoto = (iBonoLoto) Naming.lookup("//localhost:2005/Server");
		Thread []hilos=new Thread[5];
		for(int i=0;i<5;++i){
		hilos[i]=new Thread(new cBonoLoto());
		hilos[i].start();
							}
		for(int i=0;i<5;++i){
		hilos[i].join();
							}
	
															}


				}