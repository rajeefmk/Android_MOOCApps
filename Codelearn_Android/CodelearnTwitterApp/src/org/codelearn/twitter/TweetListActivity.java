package org.codelearn.twitter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class TweetListActivity extends ListActivity {
	
	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	
	List<Tweet> tweets = new ArrayList<Tweet>();
	List<Tweet> tweetsRead = new ArrayList<Tweet>();
	List<Tweet> tweetsWrite = new ArrayList<Tweet>();
	
	TweetAdapter mTweetAdapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);
		
		
		//File Read Code: Reading from TWEETS_CACHE_FILE and Storing it to tweetsRead which later on passed to Adapter
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = openFileInput(TWEETS_CACHE_FILE);
			ois = new ObjectInputStream(fis);
			tweetsRead = (List<Tweet>) ois.readObject();
			
		}catch(Exception e){
			
			Log.e("codelearn", "Error reading tweets", e);
			
		}finally{
			
			try{
				fis.close();
				ois.close();
			}catch(Exception e){
				
			}
			
		}
		
		//Dummy Tweets Creation and 
		
		for (int i=0;i<20;i++){
			
			Tweet tweet = new Tweet();
			tweet.setTitle("A nice header for Tweet # " + i);
			tweet.setBody("Some random body text for the tweet #" + i);
			tweetsWrite.add(tweet);
		}
		
		//File Write Code - 
		
		try{
			FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE,MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tweetsWrite);
			oos.close();
			fos.close();
			
			Log.d("codelearn", "Successfully wrote tweets to the file.");
			
		}catch(Exception e){
			
			Log.e("codelearn", "Error writing tweets", e);
			
		}
		
		mTweetAdapter = new TweetAdapter(this, tweetsRead);
		setListAdapter(mTweetAdapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position,long id) {
	
		Intent intent = new Intent(this, TweetDetailActivity.class);
		intent.putExtra("MyClass",(Tweet) getListAdapter().getItem(position));
	     startActivity(intent);
	}

	
}
