import java.util.Scanner;

class Man{
	String name;
	int age;
}

public class Auto_Object_creator {
	public static void main(String[] args) {

		//What I'm trying to do here is -
		
		// Take the no. of object from the user. Pass it to a count integer. 
		//Run the outer loop until the count length. For run of this loop, a new 
		// array value needs to be defined and an inner loop needs to run which should 
		// create a new object on its every run.
		
		//Challenge 2
		// Create variables dynamically (during Runtime);
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter No. of Objects");
		int count=obj.nextInt();
		
		for(int i=0;i<count.length;i++){
			
		}
		
		for(int i=0;i<count;i++){
			
			Man man1=new Man();
			
			person[i]=man1;
		}
		
	}
}
