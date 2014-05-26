import java.util.Scanner;

class Person {

	int age;
	String name;

	int yearsToRetirement() {
		return 65 - age;
	}

	void lastMessage(int retireAge) {
		System.out.println("Hello " + name + ".Your retirement age is "
				+ retireAge);
	}

}

public class Application19 {

	public static void main(String[] args) {

		// created two new objects
		Person person1 = new Person();
		Person person2 = new Person();

		// Defined new scanner object

		Scanner input = new Scanner(System.in);

		
		System.out.println("Enter Name1- ");// Enter name of first person
		
		person1.name = input.nextLine();// Stored the name of first person

		System.out.println(); // blank line

		System.out.println("Enter Name2- "); // Asks to enter second name
		person2.name = input.nextLine(); // Stores second name

		System.out.println("Enter Age1");// Asks to enter first age
		person1.age = input.nextInt();// Stores first age

		System.out.println();

		System.out.println("Enter Age2"); //input second age
		person2.age = input.nextInt(); //stores second age

		// Calls the yearsToRetirement method and stores calculated value to a variable
		int retireAge1 = person1.yearsToRetirement(); 
		int retireAge2 = person2.yearsToRetirement();

		//Display the last message for person1 & 2 by calling the lastMessage method.
		person1.lastMessage(retireAge1);
		System.out.println();
		person2.lastMessage(retireAge2);

	}
}
