/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.*;

class monitorCadena_1{
	private ArrayList<int[][]>buffer_1 = new ArrayList<int[][]>();

	public monitorCadena_1(){}

	public synchronized void empezar_procesoA(){//Debe pedir por teclado las columnas y filas del buffer_1
		Random rd = new Random();
		int [][]matriz= new int[10][10];
			//System.out.println("El usuario "+(id+1)+" empieza el proceso A");
			while(buffer_1.size()>=100){
				try{
					System.out.println("Buffer 1 lleno");
					wait();
				}catch(Exception ex){}
				}

				for(int i=0;i<10;++i){
					for(int j=0;j<10;++j){
						matriz[i][j]=rd.nextInt(10);
																}
															}
						buffer_1.add(matriz);

					System.out.println("Se introdujo la matriz en la posicion "+buffer_1.size()+" del buffer 1");
				notifyAll();
			}

			/**
			 * @param  int[][] matriz ya procesada
			 */
		public synchronized int[][] terminar_procesoA(){
			while(buffer_1.size()<=0){
				try{
					System.out.println("Buffer 1 vacio");
					wait();
				}catch(Exception ex){}
			}
			int [][]matriz=buffer_1.get(0);
			buffer_1.remove(0);
			System.out.println("Se ha extraido una matriz del buffer_1");
			return matriz;
		}

}
