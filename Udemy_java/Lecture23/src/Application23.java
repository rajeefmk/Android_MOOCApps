class Thing{
	public static int count=0;
	public String name;
	public static String description;
	public static final int LUCKY_NUMBER=3;
	
	public Thing(){
		count++;
	}
	public static void printName(){
		System.out.println(description);
	}
	
	public void printName2(){
		System.out.println(description);
	}
}


public class Application23 {
	public static void main(String[] args) {

		Thing.description="Rj";
		System.out.println(Thing.LUCKY_NUMBER);
		
		System.out.println("Count before object"+ Thing.count);
		
		Thing thing1=new Thing();
		System.out.println("Count after object"+ Thing.count);
		
	}
	
}
