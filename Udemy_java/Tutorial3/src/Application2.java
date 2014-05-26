
public class Application2 
{
	public static void main(String[] args) 
	{
	int myInt=7;
	String text="hello";
	String blank=" ";
	String name="Rajeef";
	
	//method 1 of adding strings
	
	String greeting=text + blank + name;
	System.out.println(greeting);
	
	//method 2 of adding strings
	
	System.out.println("hello"+" "+ "Rajeef");
	
	//method 3 of adding strings;
	
	System.out.println(text + blank + name);
	
	System.out.println(name + myInt);
	
	}
}
