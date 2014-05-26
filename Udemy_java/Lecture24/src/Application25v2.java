// Using constructors and toString() to obtain Object information

class Horse{
	
	private int age;
	private String name;
	
	public Horse(int age,String name){
		this.name=name;
		this.age=age;
	}

	
	public String toString(){
		return name + ": "+ age;

	}
	
}
public class Application25v2 {
	public static void main(String[] args) {
	
		Horse horse1= new Horse(7,"Bob");
		System.out.println(horse1);
	}
}
