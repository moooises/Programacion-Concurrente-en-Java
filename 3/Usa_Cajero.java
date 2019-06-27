import java.util.Scanner;

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"> </a>
 */
public class Usa_Cajero implements Runnable{
	int saldo,turno,dinero,last;
	static int n;
	Cajero caja = new Cajero();
	
	public Usa_Cajero(int turno, int dinero,int last){
		this.last=last;
		this.turno=turno;
		this.dinero=dinero;
		
	}
	
	public void run(){
		if(turno==0)
			caja.sacar((double)dinero);
		else 
			caja.meter((double)dinero);
		
	if(last==n-1)	System.out.println("Saldo de final: "+caja.saldo());


	}
	
	
/**
 * @exception 	InterruptedException cuando un hilo esta esperando
 */
	public static void main(String[] args)throws Exception {
		
		Scanner sc = new Scanner(System.in);	

		int res,dinero,inicio;
		System.out.println("Cual es el maximo de cajeros que quieres? ");
		n=sc.nextInt();
		Thread [] hilos1 = new Thread[n];
		Thread [] hilos2 = new Thread[n];
		//double [] inicio = new double[n];
		//double [] dinero = new double[n];
		int j;

		System.out.println("Su saldo inicial es de "+10000);
		System.out.println("Cuanto de desea extraer/añadir? ");
		dinero=sc.nextInt();
		for(int i=0;i<n;++i){
		j=i%2;	
		hilos1[i] = new Thread(new Usa_Cajero(j,dinero,i));
		hilos2[i] = new Thread(new Usa_Cajero(j,dinero,i));
		hilos1[i].start();
		hilos2[i].start();
		}
		
		for(int i=0;i<n;++i){
			try{
		hilos1[i].join();
		hilos2[i].join();
			}catch(Exception ex){}
		}
					//System.out.println("Saldo de final: "+caja.saldo());

		
		System.out.println("\n");			
		
			

											}
	
						}