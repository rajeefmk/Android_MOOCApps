import java.util.Scanner;

public class Application13 {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	System.out.println("Enter Command");
	
	String text=scan.nextLine();
	
	switch (text){
		case"Start": System.out.println("Machine Started");
						break;
		case"Stop" : System.out.println("Machine Stopped");
						break;
		default:System.out.println("Command not recognized"); 	
		
	}
	}
}
