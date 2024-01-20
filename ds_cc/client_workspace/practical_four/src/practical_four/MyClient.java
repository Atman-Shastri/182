package practical_four;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		MyInterface obj = (MyInterface)Naming.lookup("rmi://localhost:2099/db");
	
//		obj.insertData();
//		boolean acknowledgment= obj.updateData();
		String data = obj.getData();
		System.out.println(data);
	}

}
