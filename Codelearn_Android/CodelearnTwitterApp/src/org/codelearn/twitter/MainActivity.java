package org.codelearn.twitter;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	
	Button _loginBtn;
	EditText mUserName,mPassword;
	AsyncToken mAsyncToken;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		String token = prefs.getString("Token",null);
		
		if(token != null){
			Log.i(TAG, "Skipping Login since Token is already saved");
			runIntent();
			finish();
		}
		
		_loginBtn = ( Button ) findViewById(R.id.btn_login);
		
		mUserName = (EditText) findViewById(R.id.fld_username);
		mPassword = (EditText) findViewById(R.id.fld_pwd);

		mAsyncToken = new AsyncToken(this);
		
		_loginBtn.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				
				String mUserNameValue = mUserName.getText().toString();
				String mPasswordValue = mPassword.getText().toString();
				mAsyncToken.execute(mUserNameValue, mPasswordValue);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void storeToken(String token){
		
		SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		Editor editor = prefs.edit();
		editor.putString("Token", token);
		editor.commit();
		Log.i(TAG,"Token is commited to sharedpreference via editor");
		
		if(token!= null){
			
			runIntent();
			Log.i(TAG, "Run intent is called");
		}
		else{
			
			Toast.makeText(this, "Login Error ! Please try again", Toast.LENGTH_LONG).show();
		}
		
	}
	
	public void runIntent(){
		
		Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
		Log.i(TAG, "Intent Initialized for TweetListActivity");
        startActivity(intent);
	}

}
