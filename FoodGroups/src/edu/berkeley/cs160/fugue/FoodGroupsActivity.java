package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodGroupsActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
        Button leaderBoard = (Button) findViewById(R.id.button1);
        Button homeCooking = (Button) findViewById(R.id.button2); 
        Button restaurantCheckIn = (Button) findViewById(R.id.button3);
        Button searchRecipes = (Button) findViewById(R.id.button4);
        Button Menu = (Button) findViewById(R.id.button5);
        
        leaderBoard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LeaderBoard.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        homeCooking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HomeCooking.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
       
        
        restaurantCheckIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RestaurantCheckIn.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        searchRecipes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SearchRecipes.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        Menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(myIntent, 0);
            }

        });

/*

public class FoodGroupsActivity extends Activity implements OnClickListener {
    //Called when the activity is first created. 
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

*/