/**
*@author Moises Guerrero Lopez
*@version 1.0
*@since November 30,2017
*/

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class ServidorHiloconPool
  implements Runnable
{
    Socket enchufe;
    public ServidorHiloconPool(Socket s)
    {enchufe = s;}

   		 /**
		*@override
		*/
    public void run()
    {
    try{
        BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
        String datos = entrada.readLine();
        int j;
        int i = Integer.valueOf(datos).intValue();
        for(j=1; j<=20; j++){
        System.out.println("El hilo "+Thread.currentThread().getName()+" escribiendo el dato "+i);
        Thread.currentThread().sleep(1000);}
        enchufe.close();
        System.out.println("El hilo "+Thread.currentThread().getName()+"cierra su conexion...");
    } catch(Exception e) {System.out.println("Error...");}
    }//run

public static void main (String[] args)
{
    int i;
    int puerto = 2001;
        try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);
                ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newCachedThreadPool();

            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                exec.execute(new ServidorHiloconPool(cable));

            }

        //while
      } catch (Exception e)
        {System.out.println("Error en sockets...");}
}//main

}//Servidor_Hilos
