package com.teamtreehouse.crystalball;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	CrystalBall mCrystalBall=new CrystalBall();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Declaring View variables and assigning them Views from layout file
		
		final TextView answerLabel= (TextView) findViewById(R.id.textView1);
		Button getAnswerButton= (Button) findViewById(R.id.button1);
		
		//getAnswerButton.setText("Enlighten Me");
		//Using the onClickListener which listens for the click of button getAnswerButton
		//and runs a code when it is clicked.
		
		getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
			String answer=mCrystalBall.getAnAnswer();
				//update the label with dynamic answer
				answerLabel.setText(answer);
				
				
			}
		});
		
		
		
	}

		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
