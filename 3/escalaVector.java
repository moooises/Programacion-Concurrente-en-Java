import java.util.Scanner;

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"> </a>
 */
class escalaVector{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int [] v = new int[100000000]; 
		int n;
		System.out.println("Por favor indique el escalar: ");
		n=sc.nextInt();
		for(int i=0;i<100000000;++i){
			v[i]=i;
		}
		for(int i=0;i<100000000;++i){
			v[i]=v[i]*n;
			//System.out.println(""+v[i]);
		}
											}	
	
					}