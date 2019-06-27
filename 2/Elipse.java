import java.lang.Math;
/**
En este programo devlaramos el constructor y los procedimientos de la clase usaElipse
*	@author Moises Guerero Lopez
*/
public class Elipse{
	
		double ejemenor;
		double ejemayor;
		double ejex;
		double ejey;
	/**
	Constructor nulo
	*/
	public Elipse(){}
	
	/**
	Constructor
	*/
	public Elipse(double ejemeno, double ejemayo, double ejx, double ejy){
		ejemenor=ejemeno;
		ejemayor=ejemayo;
		ejex=ejx;
		ejey=ejy;
	
					}
					
	/**
	Metodo para comprobar si los puntos dados se encuentras dentro o sobre la elipse
	@param Valores double que indican los valores de la elipse y el punto a comprobar
	@return Devuelve true si el punto esta en la elipse
	*/
	public boolean dentro(double ejemen, double ejemay, double centrox, double centroy, double ptx, double pty){
		if((((Math.pow((ptx-centrox),2))/(ejemay*ejemay))+((Math.pow((pty-centroy),2)/(ejemen*ejemen)))<=1))return true;
			else return false;
																										}
}