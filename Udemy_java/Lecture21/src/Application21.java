class Frog{
	String name;
	int age;
	
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
public class Application21 {
	public static void main(String[] args) {
		Frog man=new Frog();
		
		man.setName("Raj");
		man.setAge(24);
		
		System.out.println(man.getName());
		System.out.println(man.getAge());
		
		
	}

	
}
