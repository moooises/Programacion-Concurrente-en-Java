
import java.util.*;
import java.lang.*;

public class piSecuencial{
	private static Scanner sc= new Scanner(System.in);
	private static Random rd = new Random();
	private static double PI;
	private static int n;

	public static double montecarlo(int n ){
	double x,y;
	int aciertos=0;
	for(int i=0;i<n;++i){
			x=rd.nextDouble();//*r pero el radio es 1 porque es un cuadrado de 1x1
			//System.out.println("X= "+x);
			y=rd.nextDouble();
			//System.out.println("Y= "+y);
			if(Math.pow(x,2)+Math.pow(y,2)<=1){
				++aciertos;
												}
							}
			return 4*((double)aciertos/(double)n);
		}


	public static void main(String[] args){
		System.out.println("Cuantos numero quiere lanzar?");
		n=sc.nextInt();
		long time_start, time_end;
		time_start = System.currentTimeMillis();

		PI=montecarlo(n);
		System.out.println("La aproximacion del numero PI por montecarlo es: "+PI);
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");	

							}

															}
