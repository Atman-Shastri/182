package practicalfour;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	public String getData() throws Exception;

}
