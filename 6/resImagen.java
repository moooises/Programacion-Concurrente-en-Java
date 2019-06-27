/*
@author Moises Guerrero Lopez
@version 1.0
*/
import java.util.*;
public class resImagen{

	public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	Random rd= new Random();
	double time_start=0,time_end=0;
	System.out.println("Seleccione la dimension de la matriz");
	int n=sc.nextInt();//
	time_start = System.currentTimeMillis();
	int aux;
	
	int Imagen[][]=new int[n+2][n+2];
	int Resaltado[][]=new int[n+2][n+2];
	
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			aux=rd.nextInt(21);
			Imagen[i][j]=aux;
							}
						}
						
	for(int i=0;i<=n+1;++i){
			Imagen[0][i]=0;
			Imagen[n][0]=0;	
						 }
							
	for(int i = 0;i<=n+1;++i){
		Imagen[i][0]=0;
		Imagen[0][n]=0;
							} 
	System.out.println("La imagen introducida es: ");
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			System.out.print("["+Imagen[i][j]+"]");
							}
			System.out.println("\n");

						}
										
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			Resaltado[i][j]=((4*(Imagen[i][j])-Imagen[i+1][j]-Imagen[i][j+1]-Imagen[i-1][j]-Imagen[i][j-1])/8);
							}
						}
						
				System.out.println("\n");
			System.out.println("\n");

	System.out.println("EL resaltado en la imagen sera:");
	for(int i=1;i<n+1;++i){
		for(int j=1;j<n+1;++j){
			System.out.print("["+Resaltado[i][j]+"]");
							}
			System.out.println("\n");

						}
	time_end = System.currentTimeMillis();
	System.out.println("the task has taken "+(time_end - time_start)+" milliseconds");
	
						
	

}
}