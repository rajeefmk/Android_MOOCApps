class Box{
	
	String name;
	double height;
	double width;
	double length;
	
}

public class Application17 {


	public static void main(String[] args) {
	
		Box soapBox = new Box();
		soapBox.height=22;
		soapBox.width=23;
		soapBox.length=24;
		soapBox.name="First Box";
		double volume=soapBox.height*soapBox.width*soapBox.length;
		
		System.out.println(soapBox.name + "\t" +volume);
	}

}
