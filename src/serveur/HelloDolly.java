package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloDolly extends Remote{
	public String sayHelloDolly() throws RemoteException;
}
