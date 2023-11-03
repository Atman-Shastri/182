package practicalfour;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	public String getData() throws RemoteException;

	public int insertData() throws RemoteException;

	public int updateData() throws RemoteException;

	public int deleteData() throws RemoteException;
}
