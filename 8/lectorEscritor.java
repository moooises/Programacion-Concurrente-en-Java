import java.util.concurrent.*;

public class lectorEscritor{


private boolean escribiendo=false;
private int n=0;

	public synchronized void inicia_escritura(){

		while(n!=0 || escribiendo){

		try{
			wait();
		}catch(Exception e){}//Puede petarse aqui?

									}

		escribiendo=true;
								}


	public synchronized void fin_escritura(){//dsdsad
			escribiendo=false;

			try{
				notifyAll();
			}catch(Exception ex){}

		}

	public synchronized void inicia_lectura(){

		while(escribiendo){//

			try{
			wait();
			}catch(Exception e){}
				n++;
				notifyAll();
							}
						}


	public synchronized void fin_lectura(){
			n--;
			while(n==0){
				try{
				notifyAll();//escritores.notify();
			}catch(Exception ex){}
			}

							}


}
