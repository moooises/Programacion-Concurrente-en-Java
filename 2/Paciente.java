/**
*Esta clase define lo parametro que tendremos por cada cliente y tambien encontramos el metodo contructor para cada clase
*@author Moises Guerrero L�pez
*@version 1.0
*/

public class Paciente{
	 String nombre;
	 String dni;
	 String direcc;
	 String tel;
	 String seguro;
	 
	 /**
	 Constructor Nulo
	 */
	public Paciente(){}

	/**
	*Metodo que usamos de constructor para las clases
	*@param nomb,DNI,direc,telef,segur Son los parametros que contendra cada paciente, todos ellos de tipo String
	*/
	
		public Paciente(String nomb,String DNI,String direc,String telef,String segur){
			nombre=nomb;
			dni=DNI;
			direcc=direc;
			tel=telef;
			seguro=segur;
																						}
}