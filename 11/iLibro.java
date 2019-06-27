import java.rmi.*;
public interface iLibros extends Remote{
	
	public void insertar() throws RemoteException;
	public void extraer() throws RemoteException;
	public void conslutar() throws RemoteException;
										}