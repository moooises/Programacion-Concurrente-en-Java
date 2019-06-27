import java.lang.Math; 
public class Cuadrado extends Poligono{
 
	public Pentagono(Punto p1, Punto p2,Punto p3,Punto p4){
		super(4);
		vertices= new Punto[4];
		vertices[1]= p1;
		vertices[2]= p2;
		vertices[3]= p3;
		vertices[4]= p4;

		
	}
					
	public double perimetro(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a+b+c+d);
								}
								
	public boolean regular(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		double c=Math.sqrt(Math.pow((vertices[3].y-vertices[3].x),2)+Math.pow((vertices[4].y-vertices[4].x),2));
		double d=Math.sqrt(Math.pow((vertices[4].y-vertices[4].x),2)+Math.pow((vertices[1].y-vertices[1].x),2));
		return (a==b==c===d);
		
	}
	
	public double area(){
		double a=Math.sqrt(Math.pow((vertices[1].y-vertices[1].x),2)+Math.pow((vertices[2].y-vertices[2].x),2));
		double b=Math.sqrt(Math.pow((vertices[2].y-vertices[2].x),2)+Math.pow((vertices[3].y-vertices[3].x),2));
		return a*b;
	}
}