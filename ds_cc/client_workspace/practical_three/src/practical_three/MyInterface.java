package practical_three;
import java.rmi.*;

public interface MyInterface extends Remote {
public String getDate() throws RemoteException;
public String getTime() throws RemoteException;

public int find(int a, int b) throws RemoteException;

double calculateSquare(double a, double b) throws RemoteException;

double calculateCube(double a, double b) throws RemoteException;
}
