package practical_three;

import java.rmi.Naming;

public class solvingEquations {

	public static void main(String[] args) {
		try {
			MyInterface obj = (MyInterface) Naming.lookup("rmi://localhost:2099/equations");
			double a = 5;
			double b = 3;
			double squareResult = obj.calculateSquare(a, b);
			double cubeResult = obj.calculateCube(a, b);
			System.out.println("Atman Shastri, 182");
			System.out.println("Result of (a + b)^2 = " + squareResult);
			System.out.println("Result of (a + b)^3 = " + cubeResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
