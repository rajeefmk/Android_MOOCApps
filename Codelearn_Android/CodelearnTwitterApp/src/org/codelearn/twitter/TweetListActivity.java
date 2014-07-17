package org.codelearn.twitter;

import java.io.FileOutputStream;
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
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);
		
		for (int i=0;i<20;i++){
			
			Tweet tweet = new Tweet();
			tweet.setTitle("A nice header for Tweet # " + i);
			tweet.setBody("Some random body text for the tweet #" + i);
			tweets.add(tweet);
		}
		
		try{
			FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE,MODE_PRIVATE);
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			ois.writeObject(tweets);
			ois.close();
			fos.close();
			Log.d("codelearn", "Successfully wrote tweets to the file.");
			
		}catch(Exception e){
			
			Log.e("codelearn", "Error writing tweets", e);
			
		}
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position,long id) {
	
		Intent intent = new Intent(this, TweetDetailActivity.class);
		intent.putExtra("MyClass",(Tweet) getListAdapter().getItem(position));
	     startActivity(intent);
	}

	
}
