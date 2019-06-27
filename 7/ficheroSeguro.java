/**
*@author Moises Guerrero Lopez
*@version 1.0
*@since November 30,2017
*/

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;


public class ficheroSeguro implements Runnable{
static Scanner sc = new Scanner(System.in);
Semaphore semaforo= new Semaphore(1);
static RandomAccessFile fichero;

int i;



public ficheroSeguro(){}
public ficheroSeguro(int i){
	this.i=i;
							}

	public void run(){
		//synchronized(this){

			try{
			semaforo.acquire();
			if(i==0)fichero.writeChars(" Hilo_0 ");
			else{
				if(i==1)fichero.writeChars(" Hilo_1 ");
				else{
					if(i==2)fichero.writeChars(" Hilo_2 ");
				}
			}
			}catch(Exception e){}

		//}
		semaforo.release();
	}



public static void main(String[] args){
	int n;
try{
	fichero = new RandomAccessFile("archivo.txt","rw");//-------------

	n=3;
	Thread hilos[] = new Thread[n];
	for(int i=0;i<n;++i){
		hilos[i]=new Thread(new ficheroSeguro(i));
		hilos[i].start();
						}

	for(int i=0;i<n;++i){
		try{
		hilos[i].join();
		}catch(Exception e){}
	}


}catch(FileNotFoundException ex){
		System.out.println(ex.getMessage());
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}finally{
		try{
			if(fichero!=null){
			fichero.close();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
								}
			}


}
}
