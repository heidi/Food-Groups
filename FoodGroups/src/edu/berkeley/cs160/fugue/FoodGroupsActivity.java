package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodGroupsActivity extends Activity implements OnClickListener, DialogInterface.OnClickListener{
	
	AlertDialog logOrPlan;
	boolean logOrPlanFlag;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // set click listener
        Button leaderboardButton = (Button)findViewById(R.id.leaderboard_button);
        leaderboardButton.setOnClickListener (this); 
        Button homecookingButton = (Button)findViewById(R.id.homecooking_button);
        homecookingButton.setOnClickListener (this); 
        Button restaurantButton = (Button)findViewById(R.id.restaurant_button);
        restaurantButton.setOnClickListener (this); 
        Button recipesearchButton = (Button)findViewById(R.id.recipesearch_button);
        recipesearchButton.setOnClickListener (this); 
        Button menuButton = (Button)findViewById(R.id.menu_button);
        menuButton.setOnClickListener (this);
        
        // create dialog for cooked meal logging
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to record a home cooked meal now, or invite friends to cook with you later?")
               .setCancelable(false)
               .setPositiveButton("Record", this)
               .setNegativeButton("Plan", this);
        logOrPlan = builder.create(); 
    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
			case R.id.leaderboard_button:
				Intent myIntent = new Intent(v.getContext(), LeaderBoard.class);
                startActivityForResult(myIntent, 0);
			break;
			case R.id.homecooking_button:
				logOrPlan.show();
			break;
			case R.id.restaurant_button:
				// TODO: go to restaurant check in activity
			break;
			case R.id.recipesearch_button:
				// TODO: go to recipe search activity
			break;
			case R.id.menu_button:
				// TODO: go to food groups settings activity
			break;
		
		}
		
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (which == DialogInterface.BUTTON_POSITIVE) {
			
			Intent in = new Intent(this, HomeCookingLogActivity.class);
			startActivityForResult(in, 0);
			
			dialog.dismiss();
			
		} else {
			// TODO: start meal planning activity
		}
	}
}