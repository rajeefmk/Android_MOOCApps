import java.util.Scanner;

public class Test2 {
	
	public static String MinorOrAdult(int age){
		
		if(age<18){
			return "Minor";
		}
		else {
			return "Adult";
		}
			
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter Number");
		Scanner input=new Scanner(System.in);
		
		int age=input.nextInt();

		String result=MinorOrAdult(age);
		System.out.println(result);
		
	}
	
}

