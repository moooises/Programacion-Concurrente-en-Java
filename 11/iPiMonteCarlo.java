import java.rmi.*;
public interface iPiMonteCarlo extends Remote{
	void reset() throws RemoteException;
	void aciertos(double n,double r) throws RemoteException;
	double montecarlo() throws RemoteException;

								}