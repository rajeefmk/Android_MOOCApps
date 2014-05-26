import java.util.Scanner;

class Robot{
	String speak;
	int count;
	
	public void speak(String text){
		System.out.println("your text is " + text);
	}
	public void count(int a){
		System.out.println("your number is " + a);
	}
}

public class Application20 {
	public static void main(String[] args) {
		
		Robot man=new Robot();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Text :");
		man.speak =input.nextLine();
		
		System.out.println("Enter Number");
		man.count=input.nextInt();
		
		man.speak(man.speak);
		man.count(man.count);
	}
}
