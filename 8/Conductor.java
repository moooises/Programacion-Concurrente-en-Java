/**
*@author Moises Guerrero Lopez
*@version 1.0
*/
import java.util.*;

class Conductor{


	private String nombre;
	private String dni;
	private String matricula;
	private int id;


	//Conductor(){}//Constructor nulo
	public Conductor (String nombre, String dni, String matricula,int id){
	this.nombre=nombre;
	this.dni=dni;
	this.matricula=matricula;
	this.id=id;

																		}

	/**
	*@param Nada
	*@return Nombre del objeto
	 */

	public synchronized String getnombre(){

		return nombre;

								}
/**
	*@param Nada
	*@return Nombre del objeto
	 */

	public synchronized String getdni(){

		return dni;

								}
	/**
	*@param Nada
	*@return Nombre del objeto
	 */

	public synchronized String getmatricula(){

		return matricula;

									}

}
