package org.codelearn.twitter;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncToken extends AsyncTask<String, Void, String> {
	
	private static String url = "http://app-dev-challenge-endpoint.herokuapp.com/login";
	private static final String TAG = "AsyncToken";
	private static final String TAG_TOKEN = "token";
	MainActivity mActivity;
	
	JSONObject mJSONObjectSent;
	JSONObject mJSONObjectReceived;
	String mToken = null;
	ProgressDialog pDialog;
	
	public AsyncToken (MainActivity activity){
		
		this.mActivity = activity;
		Log.i(TAG, "activity context received");
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pDialog = new ProgressDialog(mActivity);
		pDialog.setMessage("Please wait...");
		pDialog.setCancelable(false);
		pDialog.show();
	}
	
	
	@Override
	protected String doInBackground(String... params) {
		mJSONObjectSent = new JSONObject();
		String Username = params[0];
		String Password = params[1];
		try {
			
			mJSONObjectSent.put("username",Username);
			mJSONObjectSent.put("password",Password);
			
		}catch(JSONException e){
			
			e.printStackTrace();
			Log.i(TAG, "JSON Exception caught" + e);
			
		}catch(RuntimeException e){
			
			e.printStackTrace();
			Log.i(TAG, "RuntimeException during caught JSONSent : " + e.getMessage());
		}
		
		ServiceHandler sh = new ServiceHandler();
		String response = sh.makeServiceCall(url, mJSONObjectSent);
			
		try{
			mJSONObjectReceived = new JSONObject(response);	
			Log.i(TAG, "Main object is Passed to JSONObject");
			
			mToken = mJSONObjectReceived.getString(TAG_TOKEN);
			
		}catch(JSONException e){
			
			e.printStackTrace();
			Log.i(TAG, "JSON Exception caught" + e);
		}catch(RuntimeException e){
			
			e.printStackTrace();
			Log.i(TAG, "RuntimeException during caught JSONReceived :" + e);
		}
		
		return mToken;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		
		if (pDialog.isShowing())
			pDialog.dismiss();
		mActivity.storeToken(result);
	}
	
	

}
