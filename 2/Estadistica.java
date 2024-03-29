import java.util.Scanner;

/**
*En esta clase creamos una calculadora para algunas formulas estadisticas
*esta vez sin hacer usos de otras clases para modificar,observar o construir 
*los datos
*@author Moises Guerrero Lopez
*@version 1.0
*/
class Estadistica{
	/**
	*En la clase principal creamos un array de doubles para almacenar los valores
	*que son introducidos por el usuario
	*/
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		double [] numeros;
		double media=0,var=0,moda=0,aux;
		int v1,v2,op,i,j;
		
		//System.out.println("Selecciones cuantos numero quiere: ");
		int n=Integer.parseInt(args[0]);
		numeros = new double[n];
			for(i=0;i<n;++i){
				System.out.println("Seleccione el valor "+(i+1)+" :");
				numeros[i]=sc.nextInt();
								}
		
		/**
		Creamos un menu interactivo para elegir las operaciones a realizar
		con los numeros ya pedidos, si queremos realizar estas operaciones con otros
		valores tendremos que volver a ejecutar el programa desde el comienzo
		*/
								
		do{
		System.out.println("Que desea realizar: ");
		System.out.println("1 - Media");
		System.out.println("2 - Moda");
		System.out.println("3 - Varianza");
		System.out.println("4 - Desviacion tipica");
		System.out.println("0 - Salir");
		op=sc.nextInt();
		
		switch(op){
				case 1:	media=0;
						aux=0;
						for(i=0;i<n;++i){
							aux=aux+numeros[i];
										}
						media=aux/n;
						System.out.println("La media de estos valores es: "+media);
						System.out.println("\n");
						System.out.println("Desea realizar otra operacion: ");
						break;
						
				case 2: moda=0;
						v1=0;
						v2=0;
						for(i=0;i<n;++i){
							for(j=0;j<n;++j){
								if(numeros[i]==numeros[j]) v1=v1+1;
												}
						if(v2<v1){
							v2=v1;
							moda=numeros[i];
							v1=0;
								 }
						else v1=0;
										}
						System.out.println("La moda es: "+moda);
						System.out.println("\n");
						System.out.println("Desea realizar otra operacion: ");
						break;
						
				case 3:	aux=0;
						for(i=0;i<n;++i){
							aux=aux+Math.pow((numeros[i]-media),2);
										}
						var=aux/n;
						System.out.println("La varianza es: "+var);
						System.out.println("\n");
						System.out.println("Desea realizar otra operacion: ");
						break;
						
				case 4: aux=0;
						System.out.println("La desviacion tipica es: "+Math.sqrt(var));
						System.out.println("\n");
						System.out.println("Desea realizar otra operacion: ");
						break;
				
				default: break;
						
							}
		
		}while(op!=0);
		
											}
}