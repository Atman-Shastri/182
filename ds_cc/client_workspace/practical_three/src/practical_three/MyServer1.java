package practical_three;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MyServer1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(2099);
			MyServer obj = new MyServer();
			Naming.rebind("rmi://localhost:2099/g",obj);
			Naming.rebind("rmi://localhost:2099/equations",obj);
		}catch(Exception exception) {
			System.out.println(exception);
		}

	}

}
