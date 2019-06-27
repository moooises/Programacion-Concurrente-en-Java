/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.*;

class Conductores{

	private Conductor []conductores;
	private String nombre;
	private String dni;
	private String matricula;
	private int id;


	//Conductor(){}//Constructor nulo
	public Conductores (int n){
		conductores=new Conductor[n];
		for(int i=0;i<n;++i){//Todos se llaman Jaimito
			conductores[i]= new Conductor("Jaimito", "DNI1","44054T",i);
		}
																		}
/**
*@override
 */


	/**
	*@param Identificador del objeto
	*@return Nombre del objeto
	 */

	public String getnombre(int i){

		return conductores[i].getnombre();

								}
/**
	*@param Identificador del objeto
	*@return Nombre del objeto
	 */

	public String getdni(int i){

		return conductores[i].getdni();

								}
	/**
	*@param Identificador del objeto
	*@return Nombre del objeto
	 */

	public String getmatricula(int i){

		return conductores[i].getmatricula();

									}

}
