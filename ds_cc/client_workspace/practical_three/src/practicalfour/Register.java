package practicalfour;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.MalformedURLException;
import java.rmi.*;

public class Register {

	public static void main(String[] args) throws RemoteException, MalformedURLException {

		Registry reg = LocateRegistry.createRegistry(2099);
		MyServer myServer = new MyServer();
		Naming.rebind("rmi://localhost:2099/db", myServer);

	}

}
