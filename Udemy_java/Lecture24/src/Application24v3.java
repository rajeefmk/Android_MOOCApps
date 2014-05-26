// Applicationv2 with String Binder Application

class Mango {

	private String name;
	private int age;
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(name).append(": ").append(age);
		return sb.toString();
	}
	
	public Mango(String name, int age){
		
		this.name=name;
		this.age=age;
	}
}


public class Application24v3 {
	public static void main(String[] args) {

		Mango mango1= new Mango("Rj",23);
		System.out.println(mango1);
		
		
		
		
	}
}
