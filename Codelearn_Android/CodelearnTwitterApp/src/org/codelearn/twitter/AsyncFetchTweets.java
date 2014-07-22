package org.codelearn.twitter;

import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.os.AsyncTask;
import android.util.Log;

public class AsyncFetchTweets extends AsyncTask<Void, Void, List<Tweet>>{
	
	public static final String LogCatAsync= "AsyncWriteTweets";
	
	List<Tweet> tweets = new ArrayList<Tweet>(); // Tweetlist where generated tweets are stored.
	
	//private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	
	TweetListActivity mTweetListActivity;
	
	public AsyncFetchTweets(TweetListActivity activity){
		
		mTweetListActivity = activity;
	
	}

	@Override
	protected List<Tweet> doInBackground(Void... params) {
		
		try {
			Thread.sleep(5000);
			for (int i=0;i<20;i++){
				
				Tweet tweet = new Tweet();
				tweet.setTitle("A nice header for Tweet # " + i);
				tweet.setBody("Some random body text for the tweet #" + i);
				tweets.add(tweet);
			}
			
			Log.d(LogCatAsync,"Called");
			
			AsyncWriteTweets mAsyncWriteTweets = new AsyncWriteTweets(mTweetListActivity);
			mAsyncWriteTweets.execute(tweets);
			
			Log.d(LogCatAsync,"Fetched");
			
			
		} catch (InterruptedException e1) {
			Log.i("TAG", "Thread Sleep got interrupted");
			e1.printStackTrace();
		} catch (Exception e){
			
			e.printStackTrace();
		}
		
		return tweets;
	}

	@Override
	protected void onPostExecute(List<Tweet> result) {
		//super.onPostExecute(result);
		
		mTweetListActivity.tweetDisplay(result);
		
	}
}
