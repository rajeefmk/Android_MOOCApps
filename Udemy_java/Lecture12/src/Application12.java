import java.util.Scanner;

public class Application12 {
	public static void main(String[] args) {
		
		/* Scanner scanner = new Scanner(System.in);
		
		int value=0;
		
		while(value!=5)
		{
			System.out.println("Enter Number");
			value = scanner.nextInt();
		}
		System.out.println("Got 5"); */
		
		
		int value=0;
		Scanner scan= new Scanner(System.in);
		do{
			System.out.println("Enter Number : ");
			value=scan.nextInt();
		}
		while( value!=5);
		System.out.println("Got 5");
		
	}
}
