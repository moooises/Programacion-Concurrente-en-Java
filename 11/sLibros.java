
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class sLibros extends UnicastRemoteObject implements iLibros{

	private static Libro []libros=new Libro[5];
	private Scanner sc = new Scanner(System.in);
	
	
	public sLibros()throws RemoteException{
		super();
											}

	public Libro consultar(int id){
		return libros[id];
									}
									
	public void insertar(int id,String titulo,String editorial, String autor, int edicion){
								libros[id].setnombre(titulo);
								libros[id].seteditorial(editorial);
								libros[id].setautor(autor);
								libros[id].setedicion(edicion);
									}
									
	public Libro extraer(int id){
		return libros[id];
								}
							
	public void guardar(int id,Libro l){
		libros[id]=l;
										}

			
public static void main(String[] args)throws Exception{
	
	libros[0]=new Libro("Paralelismos","UCA","Tomeu",16);
	libros[1]=new Libro("","","",0);//vacias
	libros[2]=new Libro("Palmera","Norma","Augusto",1);	
	libros[3]=new Libro("","","",0);//vacias
	libros[4]=new Libro("Java","Oracle","Horae",10);
	
	sLibros ObjRemoto = new sLibros();
	Naming.bind("Server",ObjRemoto);
	System.out.println("Servidor Remoto preparado");
	
									}

						}