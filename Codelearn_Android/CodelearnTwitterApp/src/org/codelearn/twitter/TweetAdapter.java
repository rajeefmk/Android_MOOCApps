package org.codelearn.twitter;

import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class TweetAdapter extends ArrayAdapter<Tweet> {
	
	private LayoutInflater inflater;
	
	/*public TweetAdapter(Activity activity, String[] items){
		*/
		
		public TweetAdapter(Activity activity, List<Tweet>tweets){
	
		super(activity, R.layout.row_tweet, tweets);
	    inflater = activity.getWindow().getLayoutInflater();
    }
	

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    	
    	/*return inflater.inflate(R.layout.row_tweet, parent, false);*/
    	
    	View row = inflater.inflate(R.layout.row_tweet, parent, false);
    	Tweet currentTweet = tweets.get(position);
    	TextView title = (TextView) row.findViewById(R.id.title_id);
    	title.setText(currentTweet.getTitle());
    	
    	return row;
    }
}