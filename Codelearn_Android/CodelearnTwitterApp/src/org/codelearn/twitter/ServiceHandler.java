package org.codelearn.twitter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.util.Log;

public class ServiceHandler {

	static String response = null;
	static int tokenResponseCode;
	//static String REQUEST_CODE_401;
	static String REQUEST_CODE_403;
	
	private static final String TAG = "ServiceHandler";
	
	//POST request for Voting
	public String makeServiceCall(String url, JSONObject object) {
	 try {
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost mHttpPost = new HttpPost(url);
		Log.i(TAG,"HttpPost initialized with url");
		
		String jsonString = object.toString();
		Log.i(TAG,"json Object converted to string");
		
		StringEntity se = new StringEntity(jsonString);
		se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		
		mHttpPost.setEntity(se);
			
		HttpResponse mHttpResponse = httpClient.execute(mHttpPost);
		Log.i(TAG,"httppost is executed");
		
		//HttpEntity mHttpEntity = null;
		//HttpResponse mHttpResponse = null;
		
		HttpEntity mHttpEntity = mHttpResponse.getEntity();
		Log.i(TAG, "Entity Received"+mHttpEntity);
		
		response = EntityUtils.toString(mHttpEntity);
		Log.i(TAG,"converted response "+ response);
		
		tokenResponseCode = mHttpResponse.getStatusLine().getStatusCode();
		Log.i(TAG,"statuscode "+tokenResponseCode);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
		
		/*if(tokenResponseCode == 200 ){
			
			tokenResponse = EntityUtils.toString(mHttpEntity);
			
		}
		else if(tokenResponseCode == 403){
			
			tokenResponse = REQUEST_CODE_403;
			
		}*/

	}

	
}


