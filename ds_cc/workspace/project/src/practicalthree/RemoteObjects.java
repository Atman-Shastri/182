package practicalthree;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RemoteObjects {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(2099);
			MyServer obj = new MyServer();
			Naming.rebind("rmi://localhost:2099/compare", obj);
			Naming.rebind("rmi://localhost:2099/dt", obj);
			Naming.rebind("rmi://localhost:2099/equations", obj);
		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

}
