/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.concurrent.*;
import java.util.*;

class UsamonitorCadena implements Runnable{
	private monitorCadena_1 monitor1 = new monitorCadena_1();
	private monitorCadena_2 monitor2 = new monitorCadena_2();
	private int id;

	public UsamonitorCadena(int id){
		this.id=id;
															}

	public void run(){
		monitor1.empezar_procesoA();
		monitor2.empezar_procesoB(monitor1.terminar_procesoA());
		procesoC(monitor2.terminar_procesoB());
		System.out.println("La matriz del usuario "+id+" ha terminado el proceso C");
	}
	/**
	 * @param  int[][] matriz ya procesada
	 */
		public int[][] procesoC(int[][] matriz){
			int aux=1;
			for(int i=0;i<10;++i){//col por que esta tranpuesta
				aux=aux*matriz[i][i];
									}
			return matriz;
		}

	public static void main(String [] args){
		int filas,col,matrixes;
		matrixes=101;
		filas=10;
		col=10;
	 	ExecutorService exec = Executors.newCachedThreadPool();

	 	for(int i=0;i<matrixes;++i){
	 		exec.execute(new UsamonitorCadena(i));
			exec.execute(new UsamonitorCadena(i));
			exec.execute(new UsamonitorCadena(i));

	 								}
	 	exec.shutdown();
System.out.println("Termino");

													}


}
