package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlanMealActivity extends Activity implements OnClickListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planmeal);
        
        Button backButton = (Button)findViewById(R.id.planmealback_button);
        backButton.setOnClickListener(this);
        Button doneButton = (Button)findViewById(R.id.planmealdone_button);
        doneButton.setOnClickListener(this);
        Button addFriendsButton = (Button)findViewById(R.id.addfriends_button);
        addFriendsButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
			case R.id.planmealdone_button:
			// TODO
			
			case R.id.planmealback_button:
				Intent back = new Intent();
                setResult(RESULT_OK, back);
                finish();
			break;
			
			case R.id.addfriends_button:
				Intent i = new Intent(v.getContext(), FriendSearchActivity.class);
				startActivityForResult(i, 0);
			break;
		}
		
	}
}
