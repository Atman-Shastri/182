package practicalfour;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		System.out.println("Atman Shastri, 182");
		MyInterface obj = (MyInterface) Naming.lookup("rmi://localhost:2099/db");
		int insertAcknowledgement = obj.insertData();
		System.out.println("Inserted " + insertAcknowledgement + " row(s)");
		String tableValues = obj.getData();
		System.out.println(tableValues);
		int updateAcknowledgement = obj.updateData();
		System.out.println("Updated " + updateAcknowledgement + " row(s)");
		tableValues = obj.getData();
		System.out.println(tableValues);
		int deleteAcknowledgement = obj.deleteData();
		System.out.println("Deleted " + deleteAcknowledgement + " row(s)");
	}

}
