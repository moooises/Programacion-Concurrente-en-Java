import java.lang.Math; 

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html"> </a>
 */
public class Cuadrado extends Poligono{
 
	public Cuadrado(Punto p1, Punto p2,Punto p3,Punto p4){
		super(4);
		vertices= new Punto[4];
		vertices[1]= p1;
		vertices[2]= p2;
		vertices[3]= p3;
		vertices[4]= p4;

		
	}
	
	/**
	 * Devuelve el perimetro del poligono. 
	 * @return  Perimetro del pligono
	 */	
	public double perimetro(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a+b+c+d);
								}
	
	/**
	 * Indica si el cuadrado es regular. 
	 * @return  Si es o no regular
	 */										
	public boolean regular(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a==b)&&(b==c)&&(c==d)&&(d==a);
		
	}
	
	/**
	 * Devuelve el area del cuadrado 
	 * @return  Area del cuadrado
	 */			
	public double area(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		return a*b;
	}
}