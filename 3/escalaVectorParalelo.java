import java.util.Scanner;
import java.lang.Math; 

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"> </a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html"> </a>
 */
public class escalaVectorParalelo extends Thread{
	private int vueltas;
	private int tipohilo;
	private int escalar;
	private static int [] v = new int[100000000]; 
	private int inicio;
	
	/**
		Inicializa el vector 
	 */
	
	public static void inicializar(){
		for(int i=0;i<100000000;++i){
			v[i]=i;
									}
								}
								
								
	
	public escalaVectorParalelo(int vueltas,int escalar,int inicio){
		this.vueltas=vueltas;
		//this.tipohilo=tipohilo;
		this.escalar=escalar;
		this.inicio=inicio;
															}
	
	
	public void run(){
		
		 for(int i=inicio;i<vueltas;++i){
				v[i]=v[i]*escalar;
				//System.out.println(""+v[i]);
											}
		
	}
	

	/**
	 * @exception 	InterruptedException cuando un hilo esta esperando
	 */
	public static void main(String[] args)throws Exception {
		int n;
		int e =1000000;
		Scanner sc = new Scanner(System.in);
		inicializar();
		System.out.println("Por favor indique el escalar: ");
		n=sc.nextInt();
		
		escalaVectorParalelo r = new escalaVectorParalelo(e/4,n,0);
		escalaVectorParalelo p = new escalaVectorParalelo(e/2,n,e/4);
		escalaVectorParalelo t = new escalaVectorParalelo(e/3,n,e/2);
		escalaVectorParalelo q = new escalaVectorParalelo(e,n,e/3);
		
		r.start();
		p.start();
		t.start();
		q.start();
		r.join();
		p.join();
		t.join();
		q.join();
		
		
							}
		
					
		
}
