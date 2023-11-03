package practicalfour;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Register {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(2099);
			MyServer obj = new MyServer();
			Naming.rebind("rmi://localhost:2099/db", obj);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
