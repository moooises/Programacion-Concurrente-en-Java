/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.*;

class monitorCadena_2{
	private  ArrayList<int[][]>buffer_2 = new ArrayList<int[][]>();

	public monitorCadena_2(){}//

	public synchronized void empezar_procesoB(int[][] matrizA){
		int [][]matrizB= new int[10][10];

		while(buffer_2.size()>=50){
			try{
				System.out.println("Buffer 2 lleno");
				wait();
			}catch(Exception ex){}
		}

			for(int i=0;i<10;++i){
				for(int j=0;j<10;++j){
					matrizB[i][j]=matrizA[j][i];

										}
								  }
			buffer_2.add(matrizB);

			System.out.println("Se introdujo la matriz en la posicion "+buffer_2.size()+" del buffer 2");
			notifyAll();
														}
		 /**
			 * @param  int[][] matriz ya procesada
			 */
			public synchronized int[][] terminar_procesoB(){

			while(buffer_2.size()<=0){
			try{
			  System.out.println("Buffer 2 vacio");
				wait();
		  }catch(Exception ex){}
		 }
		 int [][]matriz=buffer_2.get(0);
		 buffer_2.remove(0);
		 System.out.println("Se ha extraido una matriz del buffer_2");
		 return matriz;
								}
}
