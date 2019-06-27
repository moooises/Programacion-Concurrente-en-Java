
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.*;
import java.util.*;

public class cLibros extends Thread{
	
private static iLibros ObjRemoto;
private int op;
private int id;
private static Libro l;
//private final Lock cerrojo= new ReentrantLock();//
private static Scanner sc= new Scanner(System.in);

	public cLibros(){}
							
	public static void ejecutar(int op,int id){
		

			switch(op){
					case 1:
							try{
							l=ObjRemoto.consultar(id);
							String titulo,autor,editorial;
							int edicion;
							if(l.getnombre()!=null)System.out.println("Ranura ocupada");/////
							else{
								System.out.println("Introduce el titulo del libro: ");
								titulo=sc.next();
								System.out.println("Introduce el autor: ");
								autor=sc.next();
								System.out.println("Introduce la editorial: ");
								editorial=sc.next();
								System.out.println("Introduce la edicion: ");
								edicion=sc.nextInt();
								ObjRemoto.insertar(id,titulo,autor,editorial,edicion);
								System.out.println("Libro insertado");
								}
								
							}catch(Exception e){}
							break;
				
					case 2:
							try{
							l=ObjRemoto.consultar(id);
							//
							System.out.println("Titulo: "+l.getnombre());
							System.out.println("Editorial: "+l.geteditorial());
							System.out.println("Autor: "+l.getautor());
							System.out.println("Edicion: "+l.getedicion());
							//
							System.out.println("Libro consultado");
							ObjRemoto.guardar(id,l);
							}catch(Exception e){}
							break;
							
					case 3:
							try{
							l=ObjRemoto.extraer(id);
							
							if(l.getnombre()==(null))System.out.println("Ya esta extraida");
							else{
								l.erasenombre();
								l.eraseeditorial();
								l.eraseautor();
								l.eraseedicion();
								ObjRemoto.guardar(id,l);
								System.out.println("Libro extraido");
								}
							
							}catch(Exception e){}
							break;
						}		

						}


	public static void main(String[] args)throws Exception{
		int op,sel;
		
		Thread []hilos= new Thread[5];
		
		ObjRemoto=(iLibros)Naming.lookup("//localhost/Server");	
		
		System.out.println("1-Insertar");
		System.out.println("2-Consultar");
		System.out.println("3-Extraer");

		for(int i=0;i<5;++i){
			
			System.out.println("Que desea hacer?");
			op=sc.nextInt();
			System.out.println("En que ranura(Hay de 0-4 ranuras)");
			sel=sc.nextInt();
			ejecutar(op,sel);
								
													}
				}
}
