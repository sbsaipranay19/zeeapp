import java.util.Scanner;
public class ExceptionDemo {
	public static int div(int a , int b) {
		int c =0;
		try {
			c = a / b;
			return c;
			// inside the try or catch block then 
			// before returning the value it will execute the finally block 
			// and then it will return the value.
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter the value again");
			Scanner sc = new Scanner(System.in);
			int d = sc.nextInt();
			
			c=a/d;
			return c;
		}
		finally {
		System.out.println("hello from Zee");
		// 
		}
//		return c;
		
		
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("enter the number");
			int a = scanner.nextInt();
			System.out.println("enter the value for b");
			int b = scanner.nextInt();
			
			int result = div(a, b);
			System.out.println(result);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("inside the catch block");
			e.printStackTrace();
		}
		
		System.out.println("hello from abhi");
	}
}
