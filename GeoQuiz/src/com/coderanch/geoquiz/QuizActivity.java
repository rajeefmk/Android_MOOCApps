package com.coderanch.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_1, true),
			new TrueFalse(R.string.question_2, true),
			new TrueFalse(R.string.question_3, true),
	};
	
	private int mCurrentIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView = (TextView) findViewById(R.id.Question);
		updateQuestion();
		mTrueButton = (Button) findViewById(R.id.true_button);
		mFalseButton = (Button) findViewById(R.id.false_button);
		mNextButton = (Button) findViewById(R.id.next_button);
		
		//onClick Listener for TrueButton
		mTrueButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(QuizActivity.this, R.string.true_answer, Toast.LENGTH_LONG).show();
			}
		});
		
		//onClick Listener for FalseButton
		mFalseButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(QuizActivity.this, R.string.false_answer, Toast.LENGTH_LONG).show();
				
			}
		});
		
		//onClick Listener for NextButton
		mNextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		
	}
	
	private void updateQuestion(){
		
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	
	}

}
