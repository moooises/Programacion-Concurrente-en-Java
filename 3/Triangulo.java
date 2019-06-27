import java.lang.Math;    

/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
  * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html"> </a>
 */
public class Triangulo extends Poligono{
	
	public Triangulo(Punto p1, Punto p2,Punto p3 ){
	super(3);
	vertices = new Punto[3];
	vertices[1]= p1;
	vertices[2]= p2;
	vertices[3]= p3;
	
					}
	/**
	 * Devuelve el perimetro del poligono. 
	 * @return  Perimetro del pligono
	 */						
	public double perimetro(){
	
	
	double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
	double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
	double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
	return (a+b+c);

	
	}
	
	/**
	 * Indica si el triangulo es equilatero 
	 * @return  si es o no equilatero
	 */			
	public boolean equilatero(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a==b)&&(b==c)&&(c==a);
	}
	
	/**
	 * Indica si el triangulo es isosceles 
	 * @return  si es o no isosceles
	 */		
	public boolean isosceles(){
		
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (((a==b)&&(a==c))||((b==a)&&(b==c))||((c==a)&&(c==b)));
	}


}

	