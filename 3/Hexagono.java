import java.lang.Math;   

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html"> </a>
 */
public class Hexagono extends Poligono{

	public Hexagono(Punto p1, Punto p2,Punto p3,Punto p4,Punto p5,Punto p6){
		super(6);
		vertices= new Punto[6];
		vertices[1]= p1;
		vertices[2]= p2;
		vertices[3]= p3;
		vertices[4]= p4;
		vertices[5]= p5;
		vertices[6]= p6;
	}
	
	/**
	 * Devuelve el perimetro del poligono. 
	 * @return  Perimetro del pligono
	 */	
	public double Perimetro(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[5].y-vertices[5].x),2));
		double e=Math.sqrt(Math.pow((vertices[5].y-vertices[5].x),2)+Math.pow((vertices[6].y-vertices[6].x),2));
		double f=Math.sqrt(Math.pow((vertices[6].y-vertices[6].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return a+b+c+d+e+f;
		
	}
	
	/**
	 * Indica si el hexagono es regular. 
	 * @return  Si es o no regular
	 */		
	public boolean regular(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[5].y-vertices[5].x),2));
		double e=Math.sqrt(Math.pow((vertices[5].y-vertices[5].x),2)+Math.pow((vertices[6].y-vertices[6].x),2));
		double f=Math.sqrt(Math.pow((vertices[6].y-vertices[6].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a==b)&&(b==c)&&(c==d)&&(d==e)&&(e==f)&&(f==a);
		
	}
	
}