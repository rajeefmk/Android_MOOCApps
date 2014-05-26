class Person{
		int age;
		String name;
		
		void speak(){
			System.out.println("Hi my name is "+ name +" "+"And my age is"+ age);
		}
	}
public class Application18 {

	
	public static void main(String[] args) {
		
	Person person1=new Person();
	person1.name="Rajeef";
	person1.age=37;
	person1.speak();
	}	
}
