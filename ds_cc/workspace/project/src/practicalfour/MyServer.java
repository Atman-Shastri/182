package practicalfour;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SuppressWarnings("serial")
public class MyServer extends UnicastRemoteObject implements MyInterface {

	MyServer() throws RemoteException {
		super();
	}

	@Override
	public String getData() {
		String str = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Electric_Bill", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from bill");
			while (rs.next()) {
				str += rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " \n ";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	@Override
	public int insertData() throws RemoteException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Electric_Bill", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("insert into bill values('Atman','26/10/2023',2000.45)");
			System.out.println(result + " rows affected");
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int updateData() throws RemoteException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Electric_Bill", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("update bill set bill_amount=2200.45 where consumer_name='Atman';");
			System.out.println(result + " rows affected");
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int deleteData() throws RemoteException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Electric_Bill", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("delete from bill where consumer_name='Atman'");
			System.out.println(result + " rows affected");
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}
