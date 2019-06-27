/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 */

public class Poligono{
	public int nvertices;
	
	public Punto[] vertices;
	
	
	public Poligono(){}
	/**
	 * Asigna el numero de vertices al poligono. 
	 * @param   nvertices   numero de vertices.
	 */
	public Poligono(int nvertices){

		this.nvertices=nvertices;
					
									}
	/**
	 * Devuelve el numero de vertices del vector
	 * @return  El numero de vertices del vector
	 */								
	public int getVertices(){
		return nvertices;
							}
	/**
	 * Devuelve el punto que le pedimos. 
	 * @param   i   numero del punto.
	 * @return  Punto pedido
	 */						
	public Punto getPunto(int i){
		return vertices[i];
	}
	
	/**
	 * Devuelve el perimetro del poligono. 
	 * @return  Perimetro del pligono
	 */		
	public double perimetro(){
		return 0;	
	}
							
	
	
}
	
	
	
 	/** //constructor nulo
	public poligono(){}
	
	//constructor
	public intlados(int lados){
		this.lados=lados;
							}
	public intapotema(int apotema){
		this.apotema=apotema;
								}
							
	//observador
	public getlados(){
	return lados;
					}
					
	public getapotema(){
		return apotema;
					}
					
	public calculoperimetro(double lados, double numero){
		return (numero*lados)
														}
	*/			