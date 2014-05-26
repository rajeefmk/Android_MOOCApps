class Box{
			double height;
			double width;
			double length;
			double volume(){
				return height*width*length;
			
		    }
}
			
public class Test {
	
	public static void main(String[] args) {
	
		Box obj=new Box();
		obj.height=23;
		obj.width=24;
		obj.length=25;
		double vol=obj.volume();
		System.out.println(vol);
		
	}
}