class Machine{
	String name;
	public Machine(){
		System.out.println("Constructor is Running");
		
		name="Rajeef";
	}
	
}

public class Application22 {
	public static void main(String[] args) {

		Machine machine1=new Machine();
		
		System.out.println(machine1.name);
		
	}
}
