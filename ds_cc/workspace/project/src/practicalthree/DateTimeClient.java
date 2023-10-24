package practicalthree;

import java.rmi.Naming;

public class DateTimeClient {

	public static void main(String[] args) {
		try {
			RemoteInterface obj = (RemoteInterface) Naming.lookup("rmi://localhost:2099/dt");
			System.out.println("Atman Shastri, 182");
			System.out.println("Date is : " + obj.getDate());
			System.out.println("Time is : " + obj.getTime());
		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

}
