
/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 */
public class Usa_Hilo {

	
/**
 * @exception 	InterruptedException cuando un hilo esta esperando
 */

public static void main(String[] args) throws Exception{
	
      Hilo p = new Hilo(10000, 0); 
      Hilo q = new Hilo(10000, 1); 
      p.start(); 
      q.start(); 
      p.join(); 
      q.join(); 

      System.out.println(""+Hilo.observar());
  }

		}