package practical_three;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class MyServer extends UnicastRemoteObject implements MyInterface{

	MyServer() throws RemoteException{
		super();
	}
	
//	public String getDate() throws RemoteException{
//		return new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString();
//	}
//	
//	public String getTime() throws RemoteException{
//		return new SimpleDateFormat("hh:mm:ss").format(new Date()).toString();
//	}
	
	public int find(int a, int b) {
		if(a>b) {
			return a;
		} else {
			return b;
		}
	}
}
