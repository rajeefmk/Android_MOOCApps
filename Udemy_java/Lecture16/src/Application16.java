public class Application16 {
	public static void main(String[] args) {

	//	int[][] grid={
		//		{2,3,5},
			//	{6,5},
				//{5,6,7,8}
		     //   };

// Grid Special Case
		int[][] grid= new int[2][];
 
		
	    grid[0]=new int[2];
	    grid[1]=new int[3];
	    
	  grid[0][1]=5;
	  
	  System.out.println(grid[0][1]);
	 
// String Special Case
	  String[][] text=new String[2][];
	  text[0] = new String[1];
	  
	 text[0][0]="hey THere";
	 
	 System.out.println(text[0][0]);
		
//String Normal Case
	 String[][] word= new String[2][2];
		
		word[0][1]="Whatsap RJ";
		System.out.println(word[0][1]); 
		
		
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				System.out.print(grid[row][col] + "\t");
			}
			System.out.println(); 
		
		} 
		
		
	}
}
