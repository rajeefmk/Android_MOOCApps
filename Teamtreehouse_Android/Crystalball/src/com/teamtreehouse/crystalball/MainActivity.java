package com.teamtreehouse.crystalball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamtreehouse.crystalball.ShakeDetector.OnShakeListener;

public class MainActivity extends Activity {
	
	private CrystalBall mCrystalBall=new CrystalBall();
	private TextView mAnswerLabel;
	private ImageView mCrystalBallImage;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	//private Button mGetAnswerButton;
	public static final String TAG = MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Assigning Views from the layout file
		//mGetAnswerButton= (Button) findViewById(R.id.button1);
		mAnswerLabel= (TextView) findViewById(R.id.textView1);
		mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);
		
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mShakeDetector = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				
				handleNewAnswer();
			}
		});
		
		Log.d(TAG, "We are logging from onCreate");
		
		/*Toast welcomeToast = Toast.makeText(this, "Yay! Our Activity was created",
				Toast.LENGTH_LONG);
		
		welcomeToast.setGravity(Gravity.TOP, 0,	10);
		welcomeToast.show();*/
		
		
		//getAnswerButton.setText("Enlighten Me");
		//Using the onClickListener which listens for the click of 
		//button getAnswerButton
		//and runs a code when it is clicked.
		
		/*mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				handleNewAnswer();
			}
		
		});*/
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer, 
				SensorManager.SENSOR_DELAY_UI);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		mSensorManager.unregisterListener(mShakeDetector);
		
	}


	


	private void handleNewAnswer() {
		String answer=mCrystalBall.getAnAnswer();
			//update the label with dynamic answer
			mAnswerLabel.setText(answer);
			
		animateCrystalBall(); 
		animateAnswer();
		playSound();
	}
	
	private void animateCrystalBall(){
		
		
		mCrystalBallImage.setImageResource(R.drawable.ball_animation);;
		
		AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
		 
		if (ballAnimation.isRunning()){
			
			ballAnimation.stop();
		}
		ballAnimation.start();
	
	}
	
	private void animateAnswer(){
		
		AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
		fadeInAnimation.setDuration(1500);
		fadeInAnimation.setFillAfter(true);
		
		mAnswerLabel.setAnimation(fadeInAnimation); 
	}
	
	private void playSound(){
		
		MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
		player.start();
		player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				
				mp.release();
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
