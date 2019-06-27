/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.net.*;
import java.io.*;
import java.util.concurrent.locks.*;


public class reentrantServer extends Thread
{
    Socket enchufe;
    private final ReentrantLock cerrojo = new ReentrantLock();
    private static int webs;
    
/**
* @param s Socket;
*/

    public reentrantServer(Socket s)
    {enchufe = s; this.start();}

    public void run()
    {
    	cerrojo.lock();
    try{
       ++webs;
       System.out.println("Web numero: "+webs);
       enchufe.close();
    } catch(Exception e) {System.out.println("Error...");
    	}finally{
    		cerrojo.unlock();
    			}
    
    
    	
    }//run

public static void main (String[] args)
{
    webs=0;
    int puerto = 2001;
        try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);

            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                new reentrantServer(cable);
        }//while
      } catch (Exception e)
        {System.out.println("Error en sockets...");} 
}//main

}//Servidor_Hilos

