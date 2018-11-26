import java.util.Scanner;

public class Calculator{
	
	public static void main(String[] argv) {
		System.out.println("Calculator \n (press 00 to exit)");
		Scanner scanInt = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);
		while(true) {
			System.out.print("\n num -> ");
			int a = scanInt.nextInt();
			if(a == 00) {
				System.out.println("\nBye!");
				break;
			}
			System.out.print("operator -> ");
			String sign = scanStr.nextLine();
			System.out.print("num -> ");
			int b = scanInt.nextInt();
			switch(sign) {
				case "+": System.out.println(a + b); break;
				case "-": System.out.println(a - b); break;
				case "*": System.out.println(a * b); break;
				case "/": System.out.println(a / b); break;
				default: System.out.println("Wrong expression. Sample: 2 + 3");
			}
		}
	}
}