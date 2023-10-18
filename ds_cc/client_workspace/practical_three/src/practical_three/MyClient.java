package practical_three;

import java.rmi.Naming;

public class MyClient {

	public static void main(String[] args) {
		try {
			MyInterface obj = (MyInterface)Naming.lookup("rmi://localhost:2099/dt");
			System.out.println("Date is : " + obj.getDate());
			System.out.println("Time is : " + obj.getTime());
		}catch(Exception exception) {
			System.out.println(exception);
		}

	}

}
