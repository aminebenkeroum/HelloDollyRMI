package serveur;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class HelloDollyServeur extends UnicastRemoteObject implements HelloDolly {

	private static final long serialVersionUID = 1L;

	protected HelloDollyServeur() throws RemoteException {
		super();
	}

	public ArrayList<String> lyricsList; 
	private int listSize = 0;
	
	public void loadList(){
		lyricsList.add("Dolly'll never go away again");
		lyricsList.add("One of your old favourite songs from way back when");
		lyricsList.add("You're still goin' strong");
		lyricsList.add("Well, hello, Dolly");
		lyricsList.add("I said hello, Dolly");
	}
	
	
	public String sayHelloDolly() throws RemoteException {
		
		lyricsList = new ArrayList<String>();
		// return a random lyric from the list
		loadList();
		listSize = lyricsList.size();
		int randomLyric = (int) (Math.random()*listSize);
		return lyricsList.get(randomLyric);
	}
	
	public static void main(String args[]){
		//Gestionnaire de secutité
		if (System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		HelloDolly dolly;
		try {
			LocateRegistry.createRegistry(1040);
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/HelloDolly";
			dolly = new HelloDollyServeur();
			Naming.rebind(url, dolly);
			System.out.println("HelloDolly can sing for you on : " + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
