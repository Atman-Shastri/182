package practical_four;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	public String getData() throws RemoteException; 
	public boolean insertData() throws RemoteException;
	public boolean updateData() throws RemoteException;
//	public boolean deleteData() throws RemoteException;
}
