package edu.berkeley.cs160.fugue;

import edu.berkeley.cs160.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodGroupsActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button leaderboardButton = (Button)findViewById(R.id.leaderboard_button);
        leaderboardButton.setOnClickListener (this); 
        Button homecookingButton = (Button)findViewById(R.id.homecooking_button);
        homecookingButton.setOnClickListener (this); 
        Button restaurantButton = (Button)findViewById(R.id.restaurant_button);
        restaurantButton.setOnClickListener (this); 
        Button recipesearchButton = (Button)findViewById(R.id.recipesearch_button);
        recipesearchButton.setOnClickListener (this); 
    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
			case R.id.leaderboard_button:
				// TODO
			break;
			case R.id.homecooking_button:
				// TODO
			break;
			case R.id.restaurant_button:
				// TODO
			break;
			case R.id.recipesearch_button:
				// TODO
			break;
		
		}
		
	}
}