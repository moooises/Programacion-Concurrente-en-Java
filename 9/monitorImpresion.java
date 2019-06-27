/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

class monitorImpresion{

	//private ReentrantLock cerrojo = new ReentrantLock();
	//private final Condition espera = cerrojo.newCondition();
	//private boolean espera=false;//--------------------
	private int impresoras;//----static?//No nunca
	private boolean []libre;


	public monitorImpresion(int n){
		libre= new boolean[n];
			for(int i=0;i<n;++i){
				libre[i]=true;
			}
			impresoras=n;
																	}
  /**
		*Comprueba las impresoras diponibles y selecciona una o espera hasta que este libre
   *@param nada
	 *@return la impresora elegida
   */
	public synchronized int coger_impresora(){


		while(impresoras<=0){
			try{
				wait();
			}catch(Exception e){}
							}
			//System.out.println("Impresora actual: "+impresoras);
			int n=0;

		while(!libre[n]){//*****
			n=(n+1);//NO hagas el modulo aqui
						}
		libre[n]=false;
		//System.out.println("Impresora actual final : "+n);
		--impresoras;


		return (n);
}


/**
*Libera la impresora seleccionada
*@param Numero de la impresora elegida
*/

	public synchronized void dejar_impresora(int e){
		libre[e]=true;
		++impresoras;
		try{
		  notifyAll();
		}catch(IllegalMonitorStateException ex){}

													}




}
