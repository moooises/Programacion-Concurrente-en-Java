/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.util.concurrent.locks.*;


class usaFiloApiAn implements Runnable{

	private filoApiAN monitor=null;
	private int filosofo;
	
/**
* @param monitor filoApiAN;
* @param filofo int;
*/

	public usaFiloApiAn(filoApiAN monitor,int filosofo){
		this.monitor=monitor;
		this.filosofo=filosofo;
										}
			
	public void run(){
		try{
		System.out.println("EL filosofo "+filosofo+" piensa");
		Thread.sleep((long)(Math.random()*1000));//pensar
		}catch(Exception e){}
		monitor.coger_tenedor(filosofo);
		try{
		System.out.println("EL filosofo "+filosofo+" come");
		Thread.sleep((long)(Math.random()*1001));//comer
		}catch(Exception e){}
		monitor.dejar_tenedor(filosofo);
		System.out.println("EL filosofo "+filosofo+" termino de comer");

	                         
	
					}
										
	public static void main(String [] args)throws Exception{
		filoApiAN monitor= new filoApiAN(5);
		Thread []hilos= new Thread[5];
		
		for(int i=0;i<5;++i){
			hilos[i]=new Thread(new usaFiloApiAn(monitor,i));
			hilos[i].start();
			 				}
		for(int i=0;i<5;++i){
			hilos[i].join();
			 				}
			
		
												}
						
					}