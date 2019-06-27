/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.util.concurrent.CyclicBarrier;
import java.util.*;
import java.util.concurrent.*;

class triatlonBarreras implements Runnable{

	private static long []tiempo= new long[100];
	private static CyclicBarrier []barrera = new CyclicBarrier[3];//Con un barrera basta
	private long inicio;
	private long end;
	private int njugador;

/**
*identificador del jugador
* @param njugador int;
*/
	public triatlonBarreras(int njugador){
	this.njugador=njugador;
	for(int i=0;i<100;++i)tiempo[i]=0;//tiempo[njugador]=0;
	for(int j=0;j<3;++j)barrera[j]=new CyclicBarrier(100);////
											}

	public void run(){
	//Comineza la 1� prueba
	inicio=System.currentTimeMillis();

	try{
	Thread.sleep((long)(Math.random()*1000));//Cambiar por clase Random
	}catch(Exception e){}

	end=System.currentTimeMillis();
	tiempo[njugador]+= (end-inicio);//+=
	System.out.println("Prueba 1 del jugador "+njugador+" acabada en "+(end-inicio)/100+" segundos");

	try{
	barrera[0].await();
	}catch(Exception e){}
	inicio=0;////
	end=0;////
	//Finaliza la 1� prueba

	//Comineza la 2� prueba
	inicio=System.currentTimeMillis();

	try{
	Thread.sleep((long)(Math.random()*1000));
	}catch(Exception e){}

	end=System.currentTimeMillis();
	tiempo[njugador]+= (end-inicio);//+=
	System.out.println("Prueba 2 del jugador "+njugador+" acabada en "+(end-inicio)/100+" segundos");

	try{
	barrera[1].await();
	}catch(Exception e){}
	inicio=0;////
	end=0;////
	//Finaliza la 2� prueba

	//Comineza la 3� prueba
	inicio=System.currentTimeMillis();

	try{
	Thread.sleep((long)(Math.random()*1000));
	}catch(Exception e){}

	end=System.currentTimeMillis();
	tiempo[njugador]+= (end-inicio);//+=
	System.out.println("Prueba 3 del jugador "+njugador+" acabada en "+(end-inicio)/100+" segundos");

	try{
	barrera[2].await();
	}catch(Exception e){}

	//Finaliza la 3� prueba

				}
/**
* @return ganador int
*el numero del ganador
*/
	public static int ganador(){
		int mejor=0;
		long aux=10000;
		for(int i=0;i<100;++i){
			//System.out.println("El tiempo del jugador "+i+" es "+tiempo[i]/100);
			if(tiempo[i]<=aux){
								mejor=i;
								aux=tiempo[i];
								}
							}
	return mejor;
								}


	public static void main(String [] args){
	int ganar;
	Thread hilos[]= new Thread[100];//cambiar a thread pool

	for(int i=0;i<100;++i){
	hilos[i]=new Thread(new triatlonBarreras(i));
	hilos[i].start();
							}

	for(int j=0;j<100;++j){
		try{
			hilos[j].join();
		}catch(Exception e){}
							}

	ganar=ganador();
	System.out.println("El ganador es el jugador numero "+ganar);


											}


						}
