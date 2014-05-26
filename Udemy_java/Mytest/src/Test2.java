import java.util.Scanner;

class Person{
	
	int age;
	String name;
	
	int yearsToRetirement(){
		return 65-age;
	}
	
	void  lastMessage(int retireAge){
		System.out.println("Hello "+ name +".Your retirement age is "+ retireAge );
	}
	
}

public class Test2 {


	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter Name1- ");
		String name1=input.nextLine();
		
		System.out.println();
		
		System.out.println("Enter Name2- ");
		String name2=input.nextLine();
		
		
		System.out.println("Enter Age1");
		int age1=input.nextInt();
		
		System.out.println();
		
		System.out.println("Enter Age2");
		int age2=input.nextInt();
		
		Person person1=new Person();
		
		person1.name=name1;
		person1.age=age1;
		
		Person person2=new Person();
		
		person2.name=name2;
		person2.age=age2;
				
		int retireAge1=person1.yearsToRetirement();
		int retireAge2=person2.yearsToRetirement();
		
		person1.lastMessage(retireAge1);
		System.out.println();
		person2.lastMessage(retireAge2);
		
		
	}
}
