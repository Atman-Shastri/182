package practicalfour;

import java.rmi.Naming;

import practicalfour.MyInterface;

public class MyClient {

	public static void main(String[] args) {
		try {
			MyInterface obj = (MyInterface)Naming.lookup("rmi://localhost:2099/db");
			System.out.println("Data is : " + obj.getData());
		}catch(Exception exception) {
			System.out.println(exception);
		}

	}

}
