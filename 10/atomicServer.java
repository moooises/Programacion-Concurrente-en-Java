/**
* @autor Moises Guerrero Lopez
* @version 1.0
*/

import java.net.*;
import java.io.*;
import java.util.concurrent.atomic.*;


public class atomicServer extends Thread
{
    Socket enchufe;
    static AtomicLong atomico;
 
/**
* @param s Socket;
*/
    public atomicServer(Socket s)
    {enchufe = s; this.start();}


    public void run()
    { 
    try{
       atomico.incrementAndGet();
       System.out.println("Web numero: "+atomico);
       enchufe.close();
    } catch(Exception e) {System.out.println("Error...");}
    }//run

public static void main (String[] args)
{
 
    int puerto = 2001;
        try{
        	atomico = new AtomicLong(0);
            ServerSocket chuff = new ServerSocket (puerto, 3000);

            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                new atomicServer(cable);
        }//while
      } catch (Exception e)
        {System.out.println("Error en sockets...");} 
}//main

}//Servidor_Hilos

