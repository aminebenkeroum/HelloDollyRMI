package client;

import java.rmi.Naming;
import serveur.HelloDolly;

public class ClientDolly {
	
	/**
	  This Java Application Symbolizes the hope and enthusiasm of an entire generation summed up
	  in two words sung most famously by Louis Armstrong: Hello, Dolly.
	  When  requested you will randomly see a lyric from Hello, Dolly.
	  By Amine BK inspired by the famous Wordpress Plugin: Hello, Dolly.
	 **/
	 
	public static void main(String args[]){
		//Gestionnaire de secutité
		if (System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		//Obtenir l'interface
		try {
			HelloDolly dolly = (HelloDolly) Naming.lookup("rmi://192.168.19.1/HelloDolly");
			System.out.print(dolly.sayHelloDolly());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
