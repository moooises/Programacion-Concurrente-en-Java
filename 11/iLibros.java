import java.rmi.*;
public interface iLibros extends Remote{
	
	public void insertar(int id,String titulo,String editorial,String autor,int edicion) throws RemoteException;
	public Libro extraer(int id) throws RemoteException;
	public Libro consultar(int id) throws RemoteException;
	public void guardar(int id,Libro l) throws RemoteException;
										}