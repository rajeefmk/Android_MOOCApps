package org.codelearn.twitter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
	
		List<Tweet> tweetsRead = new ArrayList<Tweet>();
	List<Tweet> tweetsWrite = new ArrayList<Tweet>();
	
	TweetAdapter mTweetAdapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);
		
		
		//File Read Code: Reading from TWEETS_CACHE_FILE and Storing it to tweetsRead arraylist
		//which is later on passed to Adapter
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
		
		tweetDisplay(tweetsRead);
			
		
		AsyncFetchTweets mAsyncFetchTweets = new AsyncFetchTweets(this);
		
		mAsyncFetchTweets.execute();
		
		//Dummy Tweets Creation and adding it to "tweetsWrite ArrayList."
		
			/*for (int i=0;i<20;i++){
				
				Tweet tweet = new Tweet();
				tweet.setTitle("A nice header for Tweet # " + i);
				tweet.setBody("Some random body text for the tweet #" + i);
				tweetsWrite.add(tweet);
			}*/
		
		//Writing to TWEETS_CACHE_FILE from "tweetsWrite ArrayList" ( Happens at "oos.writeObject(tweetWrite)" )
		
				/*try{
					FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE,MODE_PRIVATE);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(tweetsWrite);
					oos.close();
					fos.close();
					
					Log.d("codelearn", "Successfully wrote tweets to the file.");
					
				}catch(Exception e){
					
					Log.e("codelearn", "Error writing tweets", e);
					
				}*/
		
		
		
			
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position,long id) {
	
		Intent intent = new Intent(this, TweetDetailActivity.class);
		
		Tweet mTweet = (Tweet) getListAdapter().getItem(position);
		
		intent.putExtra("MyTweet",mTweet);
	    startActivity(intent);
	     
	     
	}
	
	public void tweetDisplay(List<Tweet> tweetsRead){
			
			mTweetAdapter = new TweetAdapter(this, tweetsRead);
			setListAdapter(mTweetAdapter);
	}
	
	
}




