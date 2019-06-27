/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 */
 
public class Hilo extends Thread{ 
    private int tipoHilo; 
    private static int n=0; //variable de clase 
    private int nVueltas; 
    
 
    public Hilo(int nVueltas, int tipoHilo) 
    {this.nVueltas=nVueltas; this.tipoHilo=tipoHilo;} 
 
    public void run() 
    { 
      switch(tipoHilo){ 
        case 0: for(int i=0; i<nVueltas; i++)n++; break; 
        case 1: for(int i=0; i<nVueltas; i++)n--; break; 
      } 
    }
    
    /**
	 * Devuelve el valor de n. 
	 * @return  Valor de n.
	 */		
    public static int observar(){
    	return n;
    						}
 
  
 
}