package org.codelearn.twitter;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncWriteTweets extends AsyncTask<List<Tweet>, Void, Void>{
	
	TweetListActivity mTweetListActivity;
	
	List<Tweet> tweetsWrite = new ArrayList<Tweet>();
	
	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	
	public AsyncWriteTweets(TweetListActivity mTweetListActivity) {
		//super();
		this.mTweetListActivity = mTweetListActivity;
	}


	@Override
	protected Void doInBackground(List<Tweet>... params) {
		
		try{
			Thread.sleep(5000);
			Log.d("Thread Sleep Called", "Called");
			
			FileOutputStream fos = mTweetListActivity.openFileOutput(TWEETS_CACHE_FILE, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tweetsWrite);
			oos.close();
			fos.close();
			
			Log.d("File Path",mTweetListActivity.getFileStreamPath(TWEETS_CACHE_FILE).getAbsolutePath().toString());
		}catch(Exception e){
			
			Log.d("Error in Asynch Task",""+e.toString());
		}
		
		return null;
	}
	
	

}
