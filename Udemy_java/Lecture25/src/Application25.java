//Appending string,integers using StringBuilder instead of concatenation.
public class Application25 {
	public static void main(String[] args) {

		StringBuilder sb=new StringBuilder();
		
		sb.append("Hi ").append("how are u").append("Lets get it done");
		
		System.out.println(sb.toString());
		
		System.out.printf("This is no %-10d & second number %d",5,120);
	}
}
