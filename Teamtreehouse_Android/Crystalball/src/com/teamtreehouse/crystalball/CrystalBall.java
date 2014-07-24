package com.teamtreehouse.crystalball;

import java.util.Random;

public class CrystalBall {

//Member Variables (Properties of the Object)
	public String[] mAnswers={
			"It is Certain",
			"It is decidedly so",
			"All sign says YES",
			"The stars are not aligned",
			"My reply is no",
			"It is doubtful",
			"Better not tell you now",
			"Concentrate and ask again",
			"Unable to answer now",
			"It is hard to say"};
	
// Methods (Abilities: things the object can do)
	
	public String getAnAnswer(){
		
		String answer="";
		
		//Randomly select one of three answers : Yes,No or Maybe
		
		Random randomGenerator = new Random();// Construct a new Random number Generator
		int randomNumber= randomGenerator.nextInt(mAnswers.length);
		
		//The Array Case
				answer = mAnswers[randomNumber];
				
				return answer;
		
		//answer=Integer.toString(randomNumber);
		
		/*//Convert random number to text string
		// 0 to Yes;
		// 1 to No;
		// 2 to Maybe;
		
		if(randomNumber == 0){
			answer="Yes";
		}
		else if(randomNumber == 1){
			answer="No";
		}
		else if(randomNumber==2){
			answer="Maybe";
		}
		else{
			answer="Sorry, There was an error";
		}*/
		
		
		
	}
}
