package org.codelearn.twitter;

import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TweetListActivity extends ListActivity {

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
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position,long id) {
	
		Intent intent = new Intent(this, TweetDetailActivity.class);
		//intent.putExtra("MyClass",(Tweet) getListAdapter().getItem(position));
	     startActivity(intent);
	}

	
}
