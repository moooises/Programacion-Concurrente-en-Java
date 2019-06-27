/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.util.concurrent.*;
import java.net.*;
import java.io.*;


public class clienteContador implements Runnable
{
	public clienteContador(){}
	
	public void run(){
	try{
            System.out.println("Realizando conexion...");
            Socket cable = new Socket("localhost", 2001);
            cable.close();
            }catch (Exception e) {System.out.println("Error en sockets...");}
            
			}
	
    public static void main (String[] args){
     ExecutorService exec = Executors.newCachedThreadPool();
     for(int i=0; i<100; i++){
        exec.execute(new clienteContador());
        						}
     exec.shutdown();
     try{
     exec.awaitTermination(1,TimeUnit.DAYS);
     }catch(Exception e){}
    }//main 
}//Cliente_Hilos

