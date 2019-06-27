/**
*@author Moises Guerrero Lopez
*@version 1.0
*/

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class drakkarVikingo implements Runnable{
   private final ReentrantLock lock = new ReentrantLock();
	private static int marmita=10;//volatile???
	private int id;

	public drakkarVikingo(int id){
	this.id=id;

	//vikingos[]=new Vikingo[n]
									}
	/**
*@override
 */
	public void run(){

					vikingos();

								}



	public synchronized void vikingos(){

			comer();
			while(marmita<1){
				System.out.println("Marmita vacia, AVISAD AL COCINERO");
						cocinero();
			}
			System.out.println("Marmita acutal= "+marmita);
		}

	public synchronized void cocinero(){


			while(marmita>0){
				try{
					wait();
				}catch(Exception ex){}
			}
		System.out.println("Cocinero: Ya voyyyyyyyyy");
		marmita=10;
		System.out.println("Marmita llena otra vez");
		notifyAll();

												}


	public 	synchronized void comer(){
		while(marmita<1){
			try{
			wait();
		}catch(Exception ex){}
		}

		lock.lock();
		--marmita;
		lock.unlock();

		System.out.println("El vikingo "+(id+1)+" esta comiendo unas ricas anguilas");

	}

	public static void main(String[]args){
	int nTareas=4;

	ThreadPoolExecutor pool= new ThreadPoolExecutor(nTareas,12,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

	for(int i=0;i<12;++i){
		pool.execute(new drakkarVikingo(i));
						}

		pool.shutdown();
		try{
			pool.awaitTermination(2, TimeUnit.SECONDS);
	 }catch(Exception ex){}

System.out.println("No ha habido interbloqueo");
											}

}
