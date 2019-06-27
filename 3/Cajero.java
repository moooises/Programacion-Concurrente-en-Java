
/**
 * La clase Stack modela una implementación de pila LIFO de objetos de clase Integer, porque Juanma G. Hutchison me la ha pedido. 
 * @author  Moisés Guerrero López
 * @version 1.0
 * @since Nombember 4, 2017
 */
public class Cajero{
	public static double s;
	public double dinero=10000000;
	public  CuentaBancaria cuenta = new CuentaBancaria("YO",100,10000);
	public Cajero(){}
	
	/**
	 * Saca dinero de tu cuenta bancaria. 
	 * @param  d cantidad a retirar
	 */	
	public void sacar(double d){
		dinero-=d;
		cuenta.Saldo(cuenta.Saldo()-d);
	}
	
	/**
	 * Mete dinero de tu cuenta bancaria. 
	 * @param  d cantidad a ingresar
	 */	
	public void meter(double d){
			dinero+=d;
			cuenta.Saldo(cuenta.Saldo()+d);
	}
	
	/**
	 * Devuelve la cantidad de saldo de tu cuenta bancaria.
	 * @return  Cantidad de saldo
	 */			
	public double saldo(){
		s=cuenta.Saldo();
		return 	s;
	}

}