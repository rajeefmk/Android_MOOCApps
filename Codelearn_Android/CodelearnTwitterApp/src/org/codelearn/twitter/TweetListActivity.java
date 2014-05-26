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
	
	//private ListView tweetListView;
	//private String[] stringArray;
	//private ArrayAdapter<Object> tweetItemArrayAdapter;
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
		
		

		/*	stringArray = new String[10];
			for(int i=0; i<stringArray.length;i++){
				
				stringArray[i]="String"+i;
			}*/
			
			/*tweetItemArrayAdapter = new TweetAdapter(this,new String[10]);*/
			
	///		tweetItemArrayAdapter = new TweetAdapter(this,tweets);
			
			//tweetItemArrayAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, stringArray);
			//tweetItemArrayAdapter = new TweetAdapter(this, stringArray);
			//tweetListView= (ListView) findViewById(R.id.tweetList);
			
		//	setListAdapter(tweetItemArrayAdapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position,long id) {
	
	//TextView t = (TextView) v.findViewById(R.id.tweetTitle);
	//t.setText("Tweet Clicked");
		Intent intent = new Intent(this, TweetDetailActivity.class);
	     startActivity(intent);
	}

	
}