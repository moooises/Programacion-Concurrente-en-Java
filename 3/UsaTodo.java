/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 */

public class UsaTodo{
	public static void main(String[] args){
	double p,i;
	Punto[] punto= new Punto[6];
	for(int i=0;i<6;++i)punto[i]= new Punto(i,i+1);
	
	Triangulo t=new Triangulo(punto[1],punto[2],punto[3]);
	System.out.println("Perimetro Triangulo: "+t.perimetro());
	if(t.equilatero())System.out.println("Es equilatero");
	else System.out.println("No es equilatero");
	if(t.isosceles())System.out.println("Es isosceles");
	else System.out.println("No es isosceles");
	
	Cuadrado r=new Cuadrado(punto[1],punto[2],punto[3],punto[4]);
	System.out.println("Perimetro Cuadrado: "+r.perimetro());
	if(trregular())System.out.println("Es regular");
	else System.out.println("No es regular");
	System.out.println("El area es "+r.area());
	
	Pentagono g= new Pentagono(punto[1],punto[2],punto[3],punto[4],punto[5]);
	System.out.println("Perimetro Pentagono: "+g.perimetro());
	if(g.regular())System.out.println("Es regular");
	else System.out.println("No es regular");
	
	Hexagono h= new Hexagono(punto[1],punto[2],punto[3],punto[4],punto[5],punto[6]);
	System.out.println("Perimetro Hexagono: "+h.perimetro());
	if(h.regular())System.out.println("Es regular");
	else System.out.println("No es regular");

	
											}

}