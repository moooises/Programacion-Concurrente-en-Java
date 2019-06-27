/**Ejemplo de cliente de sockets
 *@author  Moises Guerrero Lopez
 *@version 1.0
 *@since November 30,2017
*/


import java.net.*;
import java.io.*;
import java.util.*;

public class clienteMultiple
{
    public static void main (String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Cuantas peticiones quiere realizar?");
    	int n = sc.nextInt();
    	for(int j=0;j<n;++j){
        int i = (int)(Math.random()*10);
        int puerto = 2001;
        try{
            System.out.println("Realizando conexion...");
            Socket cable = new Socket("localhost", 2001);//Si no va es porque localhost no funciona
            System.out.println("Realizada conexion a "+cable);
            PrintWriter salida= new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
            cable.getOutputStream())));
            salida.println(i);
            salida.flush();
             cable.close();
            System.out.println("Cerrando conexion...");


            }//try
                catch (Exception e)
        {System.out.println("Error en sockets...");}
        }
    }//main
}//Cliente_Hilos
